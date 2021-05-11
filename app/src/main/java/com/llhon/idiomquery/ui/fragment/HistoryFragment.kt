package com.llhon.idiomquery.ui.fragment

import com.llhon.idiomquery.R
import com.llhon.idiomquery.base.BaseMvpFragment
import com.llhon.idiomquery.mvp.contract.CollectContract
import com.llhon.idiomquery.mvp.contract.HistoryContract
import com.llhon.idiomquery.mvp.contract.HomeContract
import com.llhon.idiomquery.mvp.presenter.CollectPresenter
import com.llhon.idiomquery.mvp.presenter.HistoryPresenter
import com.llhon.idiomquery.mvp.presenter.HomePresenter

/**
 *
 * Created by LLhon on 2021/5/11 15:27.
 */
class HistoryFragment : BaseMvpFragment<HistoryContract.View, HistoryContract.Presenter>(), HistoryContract.View {

  companion object {
    fun newInstance(): HistoryFragment = HistoryFragment()
  }

  override fun attachLayoutRes(): Int = R.layout.fragment_history

  override fun lazyLoad() {

  }

  override fun createPresenter(): HistoryContract.Presenter = HistoryPresenter()
}