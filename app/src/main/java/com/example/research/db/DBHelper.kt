package com.example.research.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

open class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {


    companion object {
        private const val DATABASE_NAME = "belice_pr.db"
        private const val DATABASE_VERSION = 1
        public const val TABLE_FUZZ_GERMINATION_COUNT = "fuzz_germination_count"
        public const val TABLE_FAMILY_SELECTION = "family_selection"
        public const val TABLE_S1_GENERAL_ASSESSMENT = "s1_general_assessment"
        public const val TABLE_S2_SAMPLING_BARCODE = "s2_sampling_barcode"
        public const val TABLE_S2_DROUGHT_ASSESSMENT = "s2_drought_assessment"
        public const val TABLE_S2_GENERAL_ASSESSMENT = "s2_sampling_barcode"
        public const val TABLE_S3_SAMPLING_BARCODE = "s3_sampling_barcode"
        public const val TABLE_S3_DROUGHT_ASSESSMENT = "s3_drought_assessment"






    }

    override fun onCreate(p0: SQLiteDatabase?) {

        p0?.execSQL("CREATE TABLE $TABLE_FUZZ_GERMINATION_COUNT (id_fgc INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nursery_barcode_fc TEXT(50) NOT NULL," +
                "fuzz_Activity_fgc TEXT," +
                "fuzz_Count_fgc DOUBLE NOT NULL DEFAULT 0," +
                "date_fgc TEXT," +
                "comments_fgc TEXT," +
                "data_update_fgc BOOL)")

        p0?.execSQL("CREATE TABLE $TABLE_FAMILY_SELECTION (id_fs INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "fs_barcode_fsbu TEXT(50) NOT NULL," +
                "date_fs TEXT, " +
                "subsample_fs INTEGER NOT NULL DEFAULT 0, " +
                "bundleweight_fs TEXT, " +
                "nstalks_fs TEXT, " +
                "data_update_fs BOOL)")

        p0?.execSQL("CREATE TABLE $TABLE_S1_GENERAL_ASSESSMENT (id_gas1 INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nursery_barcode_fc TEXT(50) NOT NULL," +
                "date_gas1 TEXT, " +
                "cycle_gas1 TEXT, " +
                "vrating_gas1 INTEGER, " +
                "brix_gas1 INTEGER, " +
                "nstalks_gas1 INTEGER, " +
                "dsuceptibility_gas1 TEXT," +
                "frating_gas1 TEXT, " +
                "erectness_gas1 TEXT, " +
                "dtollerance_gas1 INTEGER, " +
                "prefix_gas1 TEXT, " +
                "autonumber_gas1 INTEGER, " +
                "varietyid_gas1 TEXT, " +
                "benchmark_gas1 TEXT, " +
                "data_update_fs BOOL)")

        p0?.execSQL("CREATE TABLE $TABLE_S2_SAMPLING_BARCODE (id_sbs2 INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "varietyid_gas1 TEXT(50) NOT NULL," +
                "rep_sbs2 TEXT, " +
                "block_sbs2 TEXT, " +
                "location_sbs2 INTEGER, " +
                "brix_gas1 INTEGER, " +
                "nstalks_gas1 INTEGER, " +
                "dsuceptibility_gas1 TEXT," +
                "frating_gas1 TEXT, " +
                "erectness_gas1 TEXT, " +
                "dtollerance_gas1 INTEGER, " +
                "prefix_gas1 TEXT, " +
                "autonumber_gas1 INTEGER, " +
                "varietyid_gas1 TEXT, " +
                "benchmark_gas1 TEXT, " +
                "data_update_fs BOOL)")

        p0?.execSQL("CREATE TABLE $TABLE_S2_DROUGHT_ASSESSMENT (id_das2 INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "sb2_sbs2 TEXT(50) NOT NULL," +
                "date_das2 TEXT, " +
                "vigor_das2 INTEGER, " +
                "drating_das2 INTEGER, " +
                "dpresence_das2 INTEGER, " +
                "prating_das2 INTEGER,  " +
                "data_update_das2 BOOL)")

        p0?.execSQL("CREATE TABLE $TABLE_S2_GENERAL_ASSESSMENT (id_gas2 INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "sb2_sbs2 TEXT(50) NOT NULL," +
                "date_gas2 TEXT, " +
                "bweight_gas2 TEXT, " +
                "sample_gas2 DOUBLE, " +
                "fcondition_gas2 TEXT, " +
                "reason_gas2 TEXT, " +
                "nstalk_gas2 TEXT, " +
                "data_update_gas2 BOOL)")

        p0?.execSQL("CREATE TABLE $TABLE_S2_GENERAL_ASSESSMENT (id_gas2 INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "sb2_sbs2 TEXT(50) NOT NULL," +
                "date_gas2 TEXT, " +
                "bweight_gas2 TEXT, " +
                "sample_gas2 DOUBLE, " +
                "fcondition_gas2 TEXT, " +
                "reason_gas2 TEXT, " +
                "nstalk_gas2 TEXT, " +
                "data_update_fs BOOL)")

        p0?.execSQL("CREATE TABLE $TABLE_S2_GENERAL_ASSESSMENT (id_gas2 INTEGER PRIMARY KEY AUTOINCREMENT, sb2_sbs2 TEXT(50) NOT NULL," +
                "date_gas2 TEXT, bweight_gas2 TEXT, sample_gas2 DOUBLE, fcondition_gas2 TEXT, reason_gas2 TEXT, nstalk_gas2 TEXT, data_update_fs BOOL)")

    }


    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE $TABLE_FUZZ_GERMINATION_COUNT")
        p0?.execSQL("DROP TABLE $TABLE_FAMILY_SELECTION")
        p0?.execSQL("DROP TABLE $TABLE_S1_GENERAL_ASSESSMENT")
        p0?.execSQL("DROP TABLE $TABLE_S2_SAMPLING_BARCODE")
        p0?.execSQL("DROP TABLE $TABLE_S2_DROUGHT_ASSESSMENT")
        p0?.execSQL("DROP TABLE $TABLE_S2_GENERAL_ASSESSMENT")





        onCreate(p0)
    }
}

