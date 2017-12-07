package com.android.lgf.demo.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.lgf.demo.R;

import java.util.List;

/**
 * Created by lgf on 17-12-6.
 */

public class GotoSettingActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnGotoAccessibilitySettings;
    private Button btnGotoAddAccount;
    private Button btnGotoAirPlaneMode;
    private Button btnGotoWirelessSettings;
    private Button btnGotoAPNSettings;
    private Button btnGotoAppInfoSettings;
    private Button btnGotoApplicationDevelopmentSettings;
    private Button btnGotoApplicationSettings;
    private Button btnGotoAllApplicationSettings;
    private Button btnGotoApplicationsSettings;
    private Button btnGotoBluetoothSettings;
    private Button btnGotoDataRoamingSettings;
    private Button btnGotoDateSettings;
    private Button btnGotoDeviceInfoSettings;
    private Button btnGotoDisplaySettings;
    private Button btnGotoDreamSettings;
    private Button btnGotoInputMethodSettings;
    private Button btnGotoInternalStorageSettings;
    private Button btnGotoStorageManageSettings;
    private Button btnGotoPrivateSettings;
    private Button btnGotoLanguageSettings;
    private Button btnGotoLocationServiceSettings;
    private Button btnGotoNetworkOperatorSettings;
    private Button btnGotoNFCShareSettings;
    private Button btnGotoNFCSettings;
    private Button btnGotoSecuritySettings;
    private Button btnGotoSettings;
    private Button btnGotoSoundSettings;
    private Button btnGotoSyncSettings;
    private Button btnGotoUserDictionarySettings;
    private Button btnGotoWifiIPSettings;
    private Button btnGotoWifiListSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_setting);
        initView();
        setListener();
    }

    private void initView() {
        btnGotoAccessibilitySettings = (Button) findViewById(R.id.btn_accessibility_settings);
        btnGotoAddAccount = (Button) findViewById(R.id.btn_add_account);
        btnGotoAirPlaneMode = (Button) findViewById(R.id.btn_airplane_mode);
        btnGotoWirelessSettings = (Button) findViewById(R.id.btn_wireless_settings);
        btnGotoAPNSettings = (Button) findViewById(R.id.btn_apn_settings);
        btnGotoAppInfoSettings = (Button) findViewById(R.id.btn_app_info_settings);
        btnGotoApplicationDevelopmentSettings = (Button) findViewById(R.id.btn_application_development_settings);
        btnGotoApplicationSettings = (Button) findViewById(R.id.btn_application_settings);
        btnGotoAllApplicationSettings = (Button) findViewById(R.id.btn_manage_all_application_settings);
        btnGotoApplicationsSettings = (Button) findViewById(R.id.btn_manage_applications_settings);
        btnGotoBluetoothSettings = (Button) findViewById(R.id.btn_bluetooth_settings);
        btnGotoDataRoamingSettings = (Button) findViewById(R.id.btn_data_roaming_settings);
        btnGotoDateSettings = (Button) findViewById(R.id.btn_date_settings);
        btnGotoInputMethodSettings = (Button) findViewById(R.id.btn_input_method_settings);
        btnGotoDeviceInfoSettings = (Button) findViewById(R.id.btn_device_info_settings);
        btnGotoDisplaySettings = (Button) findViewById(R.id.btn_display_settings);
        btnGotoDreamSettings = (Button) findViewById(R.id.btn_dream_settings);
        btnGotoInternalStorageSettings = (Button) findViewById(R.id.btn_internal_storage_settings);
        btnGotoStorageManageSettings = (Button) findViewById(R.id.btn_storage_manage_settings);
        btnGotoPrivateSettings = (Button) findViewById(R.id.btn_private_settings);
        btnGotoLanguageSettings = (Button) findViewById(R.id.btn_language_selected_settings);
        btnGotoLocationServiceSettings = (Button) findViewById(R.id.btn_location_service_settings);
        btnGotoNetworkOperatorSettings = (Button) findViewById(R.id.btn_network_operator_settings);
        btnGotoNFCShareSettings = (Button) findViewById(R.id.btn_nfc_share_settings);
        btnGotoNFCSettings = (Button) findViewById(R.id.btn_nfc_settings);
        btnGotoSecuritySettings = (Button) findViewById(R.id.btn_security);
        btnGotoSettings = (Button) findViewById(R.id.btn_setting);
        btnGotoSoundSettings = (Button) findViewById(R.id.btn_sound_setting);
        btnGotoSyncSettings = (Button) findViewById(R.id.btn_sync_setting);
        btnGotoUserDictionarySettings = (Button) findViewById(R.id.btn_user_dictionary);
        btnGotoWifiIPSettings = (Button) findViewById(R.id.btn_wifi_ip_settings);
        btnGotoWifiListSettings = (Button) findViewById(R.id.btn_wifi_list_settings);
    }

    private void setListener() {
        btnGotoAccessibilitySettings.setOnClickListener(this);
        btnGotoAddAccount.setOnClickListener(this);
        btnGotoAirPlaneMode.setOnClickListener(this);
        btnGotoWirelessSettings.setOnClickListener(this);
        btnGotoAPNSettings.setOnClickListener(this);
        btnGotoAppInfoSettings.setOnClickListener(this);
        btnGotoApplicationDevelopmentSettings.setOnClickListener(this);
        btnGotoApplicationSettings.setOnClickListener(this);
        btnGotoAllApplicationSettings.setOnClickListener(this);
        btnGotoApplicationsSettings.setOnClickListener(this);
        btnGotoBluetoothSettings.setOnClickListener(this);
        btnGotoDataRoamingSettings.setOnClickListener(this);
        btnGotoDateSettings.setOnClickListener(this);
        btnGotoInputMethodSettings.setOnClickListener(this);
        btnGotoDeviceInfoSettings.setOnClickListener(this);
        btnGotoDisplaySettings.setOnClickListener(this);
        btnGotoDreamSettings.setOnClickListener(this);
        btnGotoInternalStorageSettings.setOnClickListener(this);
        btnGotoStorageManageSettings.setOnClickListener(this);
        btnGotoPrivateSettings.setOnClickListener(this);
        btnGotoLanguageSettings.setOnClickListener(this);
        btnGotoLocationServiceSettings.setOnClickListener(this);
        btnGotoNetworkOperatorSettings.setOnClickListener(this);
        btnGotoNFCShareSettings.setOnClickListener(this);
        btnGotoNFCSettings.setOnClickListener(this);
        btnGotoSecuritySettings.setOnClickListener(this);
        btnGotoSettings.setOnClickListener(this);
        btnGotoSoundSettings.setOnClickListener(this);
        btnGotoSyncSettings.setOnClickListener(this);
        btnGotoUserDictionarySettings.setOnClickListener(this);
        btnGotoWifiIPSettings.setOnClickListener(this);
        btnGotoWifiListSettings.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_accessibility_settings:
                startActivity(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                break;
            case R.id.btn_add_account:
                startActivity(Settings.ACTION_ADD_ACCOUNT);
                break;
            case R.id.btn_airplane_mode:
                startActivity(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
                break;
            case R.id.btn_wireless_settings:
                startActivity(Settings.ACTION_WIRELESS_SETTINGS);
                break;
            case R.id.btn_apn_settings:
                startActivity(Settings.ACTION_APN_SETTINGS);
                break;
            case R.id.btn_app_info_settings:
                startActivity(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, "package:" + getPackageName());
                break;
            case R.id.btn_application_development_settings:
                startActivity(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                break;
            case R.id.btn_application_settings:
                startActivity(Settings.ACTION_APPLICATION_SETTINGS);
                break;
            case R.id.btn_manage_all_application_settings:
                startActivity(Settings.ACTION_MANAGE_ALL_APPLICATIONS_SETTINGS);
                break;
            case R.id.btn_manage_applications_settings:
                startActivity(Settings.ACTION_MANAGE_APPLICATIONS_SETTINGS);
                break;
            case R.id.btn_bluetooth_settings:
                startActivity(Settings.ACTION_BLUETOOTH_SETTINGS);
                break;
            case R.id.btn_data_roaming_settings:
                startActivity(Settings.ACTION_DATA_ROAMING_SETTINGS);
                break;
            case R.id.btn_date_settings:
                startActivity(Settings.ACTION_DATE_SETTINGS);
                break;
            case R.id.btn_input_method_settings:
                startActivity(Settings.ACTION_INPUT_METHOD_SETTINGS);
                break;
            case R.id.btn_device_info_settings:
                startActivity(Settings.ACTION_DEVICE_INFO_SETTINGS);
                break;
            case R.id.btn_display_settings:
                startActivity(Settings.ACTION_DISPLAY_SETTINGS);
                break;
            case R.id.btn_dream_settings:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2) {
                    startActivity(Settings.ACTION_DREAM_SETTINGS);
                } else  {
                    Toast.makeText(this, "此功能只支持API>=18的系统", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_internal_storage_settings:
                startActivity(Settings.ACTION_INTERNAL_STORAGE_SETTINGS);
                break;
            case R.id.btn_storage_manage_settings:
                startActivity(Settings.ACTION_MEMORY_CARD_SETTINGS);
                break;
            case R.id.btn_private_settings:
                startActivity(Settings.ACTION_PRIVACY_SETTINGS);
                break;
            case R.id.btn_language_selected_settings:
                startActivity(Settings.ACTION_LOCALE_SETTINGS);
                break;
            case R.id.btn_location_service_settings:
                startActivity(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                break;
            case R.id.btn_network_operator_settings:
                startActivity(Settings.ACTION_NETWORK_OPERATOR_SETTINGS);
                break;
            case R.id.btn_nfc_share_settings:
                startActivity(Settings.ACTION_NFCSHARING_SETTINGS);
                break;
            case R.id.btn_nfc_settings:
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    startActivity(Settings.ACTION_NFC_SETTINGS);
                } else  {
                    Toast.makeText(this, "此功能只支持API>=16的系统", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_security:
                startActivity(Settings.ACTION_SECURITY_SETTINGS);
                break;
            case R.id.btn_setting:
                startActivity(Settings.ACTION_SETTINGS);
                break;
            case R.id.btn_sound_setting:
                startActivity(Settings.ACTION_SOUND_SETTINGS);
                break;
            case R.id.btn_sync_setting:
                startActivity(Settings.ACTION_SYNC_SETTINGS);
                break;
            case R.id.btn_user_dictionary:
                startActivity(Settings.ACTION_USER_DICTIONARY_SETTINGS);
                break;
            case R.id.btn_wifi_ip_settings:
                startActivity(Settings.ACTION_WIFI_IP_SETTINGS);
                break;
            case R.id.btn_wifi_list_settings:
                startActivity(Settings.ACTION_WIFI_SETTINGS);
                break;
            default:
                break;
        }
    }

    private void startActivity(String action) {
        if (!TextUtils.isEmpty(action)) {
            Intent intent = new Intent(action);
            List<ResolveInfo> resolveInfoList = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (resolveInfoList != null && resolveInfoList.size() > 0) {
                startActivity(intent);
            }
        }
    }

    private void startActivity(String action, String data) {
        if (!TextUtils.isEmpty(action)) {
            Intent intent = new Intent(action);
            intent.setData(Uri.parse(data));
            List<ResolveInfo> resolveInfoList = getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            if (resolveInfoList != null && resolveInfoList.size() > 0) {
                startActivity(intent);
            }
        }
    }
}
