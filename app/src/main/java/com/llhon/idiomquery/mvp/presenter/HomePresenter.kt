package com.llhon.idiomquery.mvp.presenter

import com.llhon.idiomquery.base.BasePresenter
import com.llhon.idiomquery.mvp.contract.HomeContract
import com.llhon.idiomquery.mvp.contract.MainContract
import com.llhon.idiomquery.mvp.model.HomeModel
import com.llhon.idiomquery.mvp.model.MainModel

/**
 *
 * Created by LLhon on 2021/5/11 15:10.
 */
class HomePresenter : BasePresenter<HomeContract.Model, HomeContract.View>(), HomeContract.Presenter {

  override fun createModel(): HomeContract.Model = HomeModel()
}