package com.majazestan.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * SimpleJsonParser by Seyyed Amir Eftekhari.
 *
 * majazestan.com
 *
 */

public class SimpleJsonParser
{
    private JSONObject jsonObjectRoot;
    private Object jsonObjectLast = null;


    public SimpleJsonParser(SimpleJsonParser jsonParser)
    {
        this.jsonObjectRoot = jsonParser.jsonObjectRoot;
        this.jsonObjectLast = jsonParser.jsonObjectLast;
    }

    public SimpleJsonParser(String jsonString)
    {
        try
        {
            jsonObjectRoot = new JSONObject(jsonString);
            reset();
            return;
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            jsonObjectRoot = new JSONObject("{}");
            reset();
            return;
        } catch (Exception e)
        {
            e.printStackTrace();
        }

        reset();
        jsonObjectRoot = null;
    }

    private void reset()
    {
        jsonObjectLast = jsonObjectRoot;
    }

    public SimpleJsonParser Object(String key)
    {
        if(jsonObjectLast instanceof JSONObject)
        {
            try
            {
                jsonObjectLast = ((JSONObject)jsonObjectLast).getJSONObject(key);
                return this;
            } catch (JSONException e)
            {
                e.printStackTrace();
            }
        }

        try
        {
            jsonObjectLast = new JSONObject("{}");
            return this;
        } catch (JSONException e)
        {
            e.printStackTrace();
        }

        return this;
        // never return null
        // new JSONObject("{}"); is true :)
    }

    public SimpleJsonParser Array(String key)
    {
        if(jsonObjectLast instanceof JSONObject)
        {
            try
            {
                jsonObjectLast = ((JSONObject)jsonObjectLast).getJSONArray(key);
                return this;
            } catch (JSONException e)
            {}
        }

        try
        {
            jsonObjectLast = new JSONArray("[]");
            return this;
        } catch (JSONException e)
        {}

        return this;
    }

    public SimpleJsonParser Index(int index)
    {
        if (jsonObjectLast instanceof JSONArray)
        {
            try
            {
                jsonObjectLast = ((JSONArray) jsonObjectLast).getJSONObject(index);
                return this;
            } catch (Exception E)
            {
            }

            try
            {
                jsonObjectLast = ((JSONArray) jsonObjectLast).getJSONArray(index);
                return this;
            } catch (Exception E)
            {
            }
        }

        try
        {
            jsonObjectLast = new JSONObject("{}");
            return this;
        } catch (JSONException e)
        {}

        return this;
    }

    public String getString(String key)
    {
        if(jsonObjectLast instanceof JSONObject)
        {
            try
            {
                String res = ((JSONObject)jsonObjectLast).getString(key);
                reset();
                return res;
            } catch (JSONException e)
            {
                e.printStackTrace();
                return "";
            }
        }

        return "";
    }

    public JSONArray getJSONArray()
    {
        if(jsonObjectLast instanceof JSONArray)
        {
            JSONArray jarray = (JSONArray) jsonObjectLast;
            reset();
            return jarray;
        }

        try
        {
            reset();
            return new JSONArray("[]");
        } catch (JSONException e)
        {}


        return null;
        // never send null
        // JSONArray("[]") is true :)
    }

    public JSONObject getJSONObject()
    {
        if(jsonObjectLast instanceof JSONObject)
        {
            JSONObject jobj = (JSONObject) jsonObjectLast;
            reset();
            return jobj;
        }

        try
        {
            reset();
            return new JSONObject("{}");
        } catch (JSONException e)
        {}


        return null;
        // never send null
        // JSONObject("{}") is true :)
    }
}
