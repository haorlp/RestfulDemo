package com.example.restfuldemo.common.utils;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;


@SuppressWarnings("deprecation")
public class JsonUtil {
    private final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.getDeserializationConfig().set(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.getSerializationConfig().set(org.codehaus.jackson.map.SerializationConfig.Feature.WRITE_NULL_MAP_VALUES,false);
        
        objectMapper.getSerializationConfig().set(org.codehaus.jackson.map.SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true) ;
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true) ;
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,true);
        objectMapper.configure(JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER,true);
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS,true);
        objectMapper.configure(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS,true);
        objectMapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS,true);
    }



    public static String object2Json(Object o) {
        if (null == o) {
            return null;
        } else {
            try {
                return objectMapper.writeValueAsString(o);
            } catch (Exception e) {
                logger.error("objectToJson:{} failure.exception:{}", o, ExceptionUtils.getStackTrace(e));
                return null;
            }
        }
    }

    public static <T> T jsonTObject(String json, Class<T> type) {
        try {
            if (StringUtils.isEmpty(json)) {
                return null;
            } else {
                return objectMapper.readValue(json, type);
            }
        } catch (Exception e) {
            logger.error("json:{} to object error.exception:", json, ExceptionUtils.getStackTrace(e));
        }
        return null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> T jsonTObject(byte[] src, TypeReference type) {
        try {
            if (StringUtils.isEmpty(src)) {
                return null;
            } else {
                return (T)objectMapper.readValue(src,type);
            }
        } catch (Exception e) {
            logger.error("byte[]:{} to object error.exception:", src, org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(e));
        }
        return null;
    }
    
    public static <T> T jsonToObject(String json, TypeReference<T> typeReference) {
        try {
            return StringUtils.isEmpty(json) ? null : objectMapper.readValue(json, typeReference);
        } catch (Exception var3) {
            logger.error("json:{} to object error.exception:", json, org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(var3));
            return null;
        }
    }
}
