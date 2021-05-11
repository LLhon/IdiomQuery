package com.llhon.idiomquery.ui.fragment

import com.llhon.idiomquery.R
import com.llhon.idiomquery.base.BaseMvpFragment
import com.llhon.idiomquery.mvp.contract.CollectContract
import com.llhon.idiomquery.mvp.contract.HomeContract
import com.llhon.idiomquery.mvp.presenter.CollectPresenter
import com.llhon.idiomquery.mvp.presenter.HomePresenter

/**
 *
 * Created by LLhon on 2021/5/11 15:27.
 */
class CollectFragment : BaseMvpFragment<CollectContract.View, CollectContract.Presenter>(), CollectContract.View {

  companion object {
    fun newInstance(): CollectFragment = CollectFragment()
  }

  override fun attachLayoutRes(): Int = R.layout.fragment_collect

  override fun lazyLoad() {

  }

  override fun createPresenter(): CollectContract.Presenter = CollectPresenter()
}