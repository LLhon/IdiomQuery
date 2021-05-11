package com.llhon.idiomquery.mvp.presenter

import com.llhon.idiomquery.base.BasePresenter
import com.llhon.idiomquery.mvp.contract.MainContract
import com.llhon.idiomquery.mvp.model.MainModel

/**
 *
 * Created by LLhon on 2021/5/11 15:10.
 */
class MainPresenter : BasePresenter<MainContract.Model, MainContract.View>(), MainContract.Presenter {

  override fun createModel(): MainContract.Model = MainModel()
}