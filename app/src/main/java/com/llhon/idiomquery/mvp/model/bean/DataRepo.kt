package com.llhon.idiomquery.mvp.model.bean

import com.squareup.moshi.Json

/**
 *
 * Created by LLhon on 2021/5/11 15:01.
 */

data class HttpResult<T>(
  @Json(name = "data") val data: T
) : BaseBean()