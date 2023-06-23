package com.ahmed.m.hassaan.core.callbacks;

import java.util.Map;

public interface OnPermissionsResult {

    void onPermissionResult(Map<String, Boolean> result, int requestCode);
}
