package com.llhon.idiomquery.mvp.contract

import com.llhon.idiomquery.base.IModel
import com.llhon.idiomquery.base.IPresenter
import com.llhon.idiomquery.base.IView
import com.llhon.idiomquery.mvp.model.bean.HttpResult
import io.reactivex.Observable

/**
 *
 * Created by LLhon on 2021/5/11 14:57.
 */
interface MainContract {

  interface View : IView {
  }

  interface Presenter : IPresenter<View> {
  }

  interface Model : IModel {
  }
}