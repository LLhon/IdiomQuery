package com.llhon.idiomquery.mvp.presenter

import com.llhon.idiomquery.base.BasePresenter
import com.llhon.idiomquery.mvp.contract.CollectContract
import com.llhon.idiomquery.mvp.model.CollectModel
import com.llhon.idiomquery.mvp.model.HomeModel

/**
 *
 * Created by LLhon on 2021/5/11 15:10.
 */
class CollectPresenter : BasePresenter<CollectContract.Model, CollectContract.View>(), CollectContract.Presenter {

  override fun createModel(): CollectContract.Model = CollectModel()
}