package com.ft.dokit


/*
* @author zhuangch
* create at 3/22/21
* description: 
*/


object FTDokitCallbackManager {
    private var _hostChangeCallback: FTHostConfigDokit.OnHostConfigChange? = null
    var hostChangeCallback: FTHostConfigDokit.OnHostConfigChange?
        get() = _hostChangeCallback
        set(value) {
            _hostChangeCallback = value
        }
}