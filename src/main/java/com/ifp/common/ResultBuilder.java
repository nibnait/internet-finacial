package com.ifp.common;

import com.ifp.common.models.ApiResultModel;

public class ResultBuilder {

    public static ApiResultModel getSuccess(Object obj) {
        return new ApiResultModel(0, obj, null);
    }

    public static ApiResultModel getNoDataSuccess(String msg) {
        return new ApiResultModel(0, null, msg);
    }

    public static ApiResultModel getError(int code, String msg) {
        return new ApiResultModel(code, null, msg);
    }

    public static ApiResultModel getResult(int code, Object data, String msg) {
        return new ApiResultModel(code, data, msg);
    }
}
