/*
 * Copyright (C) 2016 AospExtended ROM Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flare.zone.categories;

import android.content.ContentResolver;
import android.os.Bundle;

import androidx.preference.Preference;
import androidx.preference.PreferenceScreen;
import androidx.preference.Preference.OnPreferenceChangeListener;

import com.android.internal.logging.nano.MetricsProto;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;

public class NotificationsPanel extends SettingsPreferenceFragment implements
        Preference.OnPreferenceChangeListener {

    private static final String TAG = "NotificationsPanel";
    private static final String KEY_QS_SHOW_AUTO_BRIGHTNESS = "qs_show_auto_brightness";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.notificationspanel);

        ContentResolver resolver = getActivity().getContentResolver();
        PreferenceScreen preferenceScreen = getPreferenceScreen();
        Preference qsShowAutoBrightnessPreference = preferenceScreen.findPreference(KEY_QS_SHOW_AUTO_BRIGHTNESS);
	if (qsShowAutoBrightnessPreference != null) {
            boolean automaticBrightnessAvailable = getContext().getResources().getBoolean(
                    com.android.internal.R.bool.config_automatic_brightness_available);
            if (!automaticBrightnessAvailable) {
                qsShowAutoBrightnessPreference.setVisible(false);
            }
        }
    }

    @Override
    public int getMetricsCategory() {
        return MetricsProto.MetricsEvent.FLARE_ZONE;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public boolean onPreferenceChange(Preference preference, Object objValue) {
        final String key = preference.getKey();
        return true;
    }
}
