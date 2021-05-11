package com.llhon.idiomquery.ui.fragment

import com.llhon.idiomquery.R
import com.llhon.idiomquery.base.BaseMvpFragment
import com.llhon.idiomquery.mvp.contract.HomeContract
import com.llhon.idiomquery.mvp.presenter.HomePresenter

/**
 *
 * Created by LLhon on 2021/5/11 15:20.
 */
class HomeFragment : BaseMvpFragment<HomeContract.View, HomeContract.Presenter>(), HomeContract.View {

  companion object {
    fun newInstance(): HomeFragment = HomeFragment()
  }

  override fun attachLayoutRes(): Int = R.layout.fragment_home

  override fun lazyLoad() {

  }

  override fun createPresenter(): HomeContract.Presenter = HomePresenter()
}