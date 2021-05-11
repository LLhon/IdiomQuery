package com.llhon.idiomquery.ui.activity

import android.view.KeyEvent
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.llhon.idiomquery.R
import com.llhon.idiomquery.base.BaseMvpActivity
import com.llhon.idiomquery.ext.showToast
import com.llhon.idiomquery.mvp.contract.MainContract
import com.llhon.idiomquery.mvp.presenter.MainPresenter
import com.llhon.idiomquery.ui.fragment.CollectFragment
import com.llhon.idiomquery.ui.fragment.HistoryFragment
import com.llhon.idiomquery.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.bottom_navigation
import kotlinx.android.synthetic.main.toolbar.toolbar

class MainActivity : BaseMvpActivity<MainContract.View, MainContract.Presenter>(),
  MainContract.View {

  private val BOTTOM_INDEX: String = "bottom_index"

  private val FRAGMENT_HOME = 0x01
  private val FRAGMENT_COLLECT = 0x02
  private val FRAGMENT_HISTORY = 0x03

  private var mIndex = FRAGMENT_HOME

  private var mExitTime: Long = 0

  private var mHomeFragment: HomeFragment? = null
  private var mCollectFragment: CollectFragment? = null
  private var mHistoryFragment: HistoryFragment? = null

  override fun attachLayoutRes(): Int = R.layout.activity_main

  override fun initData() {

  }

  override fun start() {

  }

  override fun createPresenter(): MainContract.Presenter = MainPresenter()

  override fun initView() {
    super.initView()
    toolbar.run {
      title = getString(R.string.app_name)
      setSupportActionBar(this)
    }

    bottom_navigation.run {
      // 以前使用 BottomNavigationViewHelper.disableShiftMode(this) 方法来设置底部图标和字体都显示并去掉点击动画
      // 升级到 28.0.0 之后，官方重构了 BottomNavigationView ，目前可以使用 labelVisibilityMode = 1 来替代
      // BottomNavigationViewHelper.disableShiftMode(this)
      labelVisibilityMode = 1
      setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    showFragment(mIndex)
  }

  /**
   * 展示Fragment
   * @param index
   */
  private fun showFragment(index: Int) {
    val transaction = supportFragmentManager.beginTransaction()
    hideFragments(transaction)
    mIndex = index
    when (index) {
      FRAGMENT_HOME // 首页
      -> {
        toolbar.title = getString(R.string.app_name)
        if (mHomeFragment == null) {
          mHomeFragment = HomeFragment.newInstance()
          transaction.add(R.id.container, mHomeFragment!!, "home")
        } else {
          transaction.show(mHomeFragment!!)
        }
      }
      FRAGMENT_COLLECT  // 收藏
      -> {
        toolbar.title = getString(R.string.collect)
        if (mCollectFragment == null) {
          mCollectFragment = CollectFragment.newInstance()
          transaction.add(R.id.container, mCollectFragment!!, "collect")
        } else {
          transaction.show(mCollectFragment!!)
        }
      }
      FRAGMENT_HISTORY // 历史记录
      -> {
        toolbar.title = getString(R.string.history)
        if (mHistoryFragment == null) {
          mHistoryFragment = HistoryFragment.newInstance()
          transaction.add(R.id.container, mHistoryFragment!!, "history")
        } else {
          transaction.show(mHistoryFragment!!)
        }
      }
    }
    transaction.commit()
  }

  /**
   * 隐藏所有的Fragment
   */
  private fun hideFragments(transaction: FragmentTransaction) {
    mHomeFragment?.let { transaction.hide(it) }
    mCollectFragment?.let { transaction.hide(it) }
    mHistoryFragment?.let { transaction.hide(it) }
  }

  /**
   * NavigationItemSelect监听
   */
  private val onNavigationItemSelectedListener =
    BottomNavigationView.OnNavigationItemSelectedListener { item ->
      return@OnNavigationItemSelectedListener when (item.itemId) {
        R.id.action_home -> {
          showFragment(FRAGMENT_HOME)
          true
        }
        R.id.action_collect -> {
          showFragment(FRAGMENT_COLLECT)
          true
        }
        R.id.action_history -> {
          showFragment(FRAGMENT_HISTORY)
          true
        }
        else -> {
          false
        }

      }
    }

  override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
    if (keyCode == KeyEvent.KEYCODE_BACK) {
      if (System.currentTimeMillis().minus(mExitTime) <= 2000) {
        finish()
      } else {
        mExitTime = System.currentTimeMillis()
        showToast(getString(R.string.exit_tip))
      }
      return true
    }
    return super.onKeyDown(keyCode, event)
  }

  override fun onDestroy() {
    super.onDestroy()
    mHomeFragment = null
    mCollectFragment = null
    mHistoryFragment = null
  }
}