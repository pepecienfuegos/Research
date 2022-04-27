package com.example.research.clases

data class FamilySelection(
    var id:Int, var fs_barcode_fsbu: String,
    var date_fs: String,
    var subsample_fs: Int,
    var bundleweight_fs: String,
    var nstalks_fs:String, var data_update_fs: Boolean)