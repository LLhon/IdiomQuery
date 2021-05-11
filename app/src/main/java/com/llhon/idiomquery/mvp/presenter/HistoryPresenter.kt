package com.llhon.idiomquery.mvp.presenter

import com.llhon.idiomquery.base.BasePresenter
import com.llhon.idiomquery.mvp.contract.HistoryContract
import com.llhon.idiomquery.mvp.contract.HomeContract
import com.llhon.idiomquery.mvp.contract.MainContract
import com.llhon.idiomquery.mvp.model.HistoryModel
import com.llhon.idiomquery.mvp.model.HomeModel
import com.llhon.idiomquery.mvp.model.MainModel

/**
 *
 * Created by LLhon on 2021/5/11 15:10.
 */
class HistoryPresenter : BasePresenter<HistoryContract.Model, HistoryContract.View>(), HistoryContract.Presenter {

  override fun createModel(): HistoryContract.Model = HistoryModel()
}