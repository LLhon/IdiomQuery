package com.llhon.idiomquery.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.llhon.idiomquery.constant.Constant
import com.llhon.idiomquery.event.NetworkChangeEvent
import com.llhon.idiomquery.utils.NetWorkUtil
import com.llhon.idiomquery.utils.Preference
import org.greenrobot.eventbus.EventBus

class NetworkChangeReceiver : BroadcastReceiver() {

    /**
     * 缓存上一次的网络状态
     */
    private var hasNetwork: Boolean by Preference(Constant.HAS_NETWORK_KEY, true)

    override fun onReceive(context: Context, intent: Intent) {
        val isConnected = NetWorkUtil.isNetworkConnected(context)
        if (isConnected) {
            if (isConnected != hasNetwork) {
                EventBus.getDefault().post(NetworkChangeEvent(isConnected))
            }
        } else {
            EventBus.getDefault().post(NetworkChangeEvent(isConnected))
        }
    }

}