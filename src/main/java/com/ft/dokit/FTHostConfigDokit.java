package com.ft.dokit;

import android.content.Context;
import android.content.Intent;

import com.didichuxing.doraemonkit.kit.AbstractKit;
import com.ft.dokit.activitys.FTDokitHostCfgActivity;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

/*
 * @author zhuangch
 * create at 3/22/21
 * description:
 */
public class FTHostConfigDokit extends AbstractKit {
    public interface OnHostConfigChange {
        void onHostChanged(String newHostValue);
    }

    public FTHostConfigDokit() {}
    public FTHostConfigDokit(ArrayList<String> defaultHosts) {
        super();
        this.defaultHosts = defaultHosts;
    }

    private ArrayList<String> defaultHosts;

    public void setDefaultHosts(ArrayList<String> defaultHosts) {
        this.defaultHosts = defaultHosts;
    }

    public void setOnHostChangeListener(OnHostConfigChange listener) {
        FTDokitCallbackManager.INSTANCE.setHostChangeCallback(listener);
    }

    @Override
    public int getIcon() {
        return R.drawable.ft_host_config;
    }

    @Override
    public int getName() {
        return R.string.dokit_plugin_host_cfg;
    }

    @Override
    public void onAppInit(@Nullable Context context) {

    }

    @Override
    public void onClick(@Nullable Context context) {
        Intent intent = new Intent(context,FTDokitHostCfgActivity.class);
        intent.putStringArrayListExtra(FTDokitHostCfgActivity.DEFAULT_HOSTS_KEY, this.defaultHosts);

        assert context != null;
        context.startActivity(intent);
    }
}
