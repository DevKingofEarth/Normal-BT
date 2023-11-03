package com.demo.btdatatransfer.data.chat

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import com.demo.btdatatransfer.domain.chat.BluetoothDeviceDomain

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceDomain():BluetoothDeviceDomain{
    return BluetoothDeviceDomain(
        name = name,
        address = address
    )
}