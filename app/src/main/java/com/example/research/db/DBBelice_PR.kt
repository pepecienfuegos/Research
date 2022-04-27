package com.example.research.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.research.clases.FamilySelection
import com.example.research.clases.FuzzGerminationCount
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

class DBBelice_PR(context: Context?) : DBHelper(context) {
    val context = context


/**************************************************************************************CRUD DEL FUZZ GERMINATION COUNT**********************************************************/
        //INSERT
    fun insertFuzzGerminationCount(nursery_barcode_fc: String,fuzz_Activity_fgc: String,fuzz_Count_fgc: Double,date_fgc: String,comments:String): Long {
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        var id: Long = 0
        try {
            val values = ContentValues()
            values.put("nursery_barcode_fc",nursery_barcode_fc)
            values.put("fuzz_Activity_fgc",fuzz_Activity_fgc)
            values.put("fuzz_Count_fgc",fuzz_Count_fgc)
            values.put("date_fgc",date_fgc.toString())
            values.put("comments",comments)
            values.put("data_update_fgc",false)
            id = db.insert(TABLE_FUZZ_GERMINATION_COUNT,null,values)
        } catch (e: Exception){

        } finally {
            db.close()
        }
        return id
    }

        //SELECT TOTAL
    fun getFuzzGerminationCountLista():ArrayList<FuzzGerminationCount>{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        var listFuzzGerminationCount = ArrayList<FuzzGerminationCount>()
        var temporal: FuzzGerminationCount? = null
        var cursorGerminationCount: Cursor? = null
        cursorGerminationCount = db.rawQuery("SELECT * FROM $TABLE_FUZZ_GERMINATION_COUNT",null)
        if(cursorGerminationCount.moveToFirst()){
            do {
                temporal = FuzzGerminationCount(
                    cursorGerminationCount.getInt(0),
                    cursorGerminationCount.getString(1),
                    cursorGerminationCount.getString(2),
                    cursorGerminationCount.getDouble(3),
                    cursorGerminationCount.getString(4),
                    cursorGerminationCount.getString(5),
                    false
                )
                listFuzzGerminationCount.add(temporal)
            }while (cursorGerminationCount.moveToNext())
        }
        cursorGerminationCount.close()
        return listFuzzGerminationCount
    }

        //SELECT BUSCANDO POR ID
    fun getFuzzGerminationCount(id: Int):FuzzGerminationCount?{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        var elemento: FuzzGerminationCount? = null
        var cursorGerminationCount: Cursor? = null

        cursorGerminationCount = db.rawQuery("SELECT * FROM $TABLE_FUZZ_GERMINATION_COUNT WHERE id = $id LIMIT 1", null)
        if (cursorGerminationCount.moveToFirst()){
            elemento = FuzzGerminationCount(
                cursorGerminationCount.getInt(0),
                cursorGerminationCount.getString(1),
                cursorGerminationCount.getString(2),
                cursorGerminationCount.getDouble(3),
                cursorGerminationCount.getString(4),
                cursorGerminationCount.getString(5),
                false
            )
        }
        cursorGerminationCount.close()
        return elemento
    }

/**************************************************************************************CRUD DEL FAMILY SELECTION**********************************************************/
    //INSERT
    fun insertFamilySelection(fs_barcode_fsbu: String, date_fs: String, subsample_fs: Int, bundleweight_fs: String, nstalks_fs:String): Long {
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        var id: Long = 0
        try {
            val values = ContentValues()
            values.put("fs_barcode_fsbu",fs_barcode_fsbu)
            values.put("date_fs",date_fs.toString())
            values.put("subsample_fs",subsample_fs)
            values.put("bundleweight_fs",bundleweight_fs)
            values.put("nstalks_fs",nstalks_fs)
            values.put("data_update_fs",false)
            id = db.insert(TABLE_FAMILY_SELECTION,null,values)
        } catch (e: Exception){

        } finally {
            db.close()
        }
        return id
    }

    //SELECT TOTAL
    fun getFamilySelectionLista():ArrayList<FamilySelection>{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        var listFamilySelection = ArrayList<FamilySelection>()
        var temporal: FamilySelection? = null
        var cursorFselection: Cursor? = null
        cursorFselection = db.rawQuery("SELECT * FROM $TABLE_FAMILY_SELECTION",null)
        if(cursorFselection.moveToFirst()){
            do {
                temporal = FamilySelection(
                    cursorFselection.getInt(0),
                    cursorFselection.getString(1),
                    cursorFselection.getString(2),
                    cursorFselection.getInt(3),
                    cursorFselection.getString(4),
                    cursorFselection.getString(5),
                    false
                )
                listFamilySelection.add(temporal)
            }while (cursorFselection.moveToNext())
        }
        cursorFselection.close()
        return listFamilySelection
    }

    //SELECT BUSCANDO POR ID
    fun getFamilySelection(id: Int):FamilySelection?{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        var elemento: FamilySelection? = null
        var cursorFselection: Cursor? = null

        cursorFselection = db.rawQuery("SELECT * FROM $TABLE_FAMILY_SELECTION WHERE id = $id LIMIT 1", null)
        if (cursorFselection.moveToFirst()){
            elemento = FamilySelection(
                cursorFselection.getInt(0),
                cursorFselection.getString(1),
                cursorFselection.getString(2),
                cursorFselection.getInt(3),
                cursorFselection.getString(4),
                cursorFselection.getString(5),
                false
            )
        }
        cursorFselection.close()
        return elemento
    }

/**************************************************************************************CRUD DEL S1 GENERAL ASSESSMENT**********************************************************/
    //INSERT
    fun insertS1GeneralAssessment(nursery_barcode_fc: String,fuzz_Activity_fgc: String,fuzz_Count_fgc: Double,date_fgc: String,comments:String): Long {
    val dbHelper = DBHelper(context)
    val db = dbHelper.writableDatabase
    var id: Long = 0
    try {
        val values = ContentValues()
        values.put("nursery_barcode_fc",nursery_barcode_fc)
        values.put("fuzz_Activity_fgc",fuzz_Activity_fgc)
        values.put("fuzz_Count_fgc",fuzz_Count_fgc)
        values.put("date_fgc",date_fgc.toString())
        values.put("comments",comments)
        values.put("data_update_fgc",false)
        id = db.insert(TABLE_FUZZ_GERMINATION_COUNT,null,values)
    } catch (e: Exception){

    } finally {
        db.close()
    }
    return id
}

    //SELECT TOTAL
    fun getS1GeneralAssessmentLista():ArrayList<FuzzGerminationCount>{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        var listFuzzGerminationCount = ArrayList<FuzzGerminationCount>()
        var temporal: FuzzGerminationCount? = null
        var cursorGerminationCount: Cursor? = null
        cursorGerminationCount = db.rawQuery("SELECT * FROM $TABLE_FUZZ_GERMINATION_COUNT",null)
        if(cursorGerminationCount.moveToFirst()){
            do {
                temporal = FuzzGerminationCount(
                    cursorGerminationCount.getInt(0),
                    cursorGerminationCount.getString(1),
                    cursorGerminationCount.getString(2),
                    cursorGerminationCount.getDouble(3),
                    cursorGerminationCount.getString(4),
                    cursorGerminationCount.getString(5),
                    false
                )
                listFuzzGerminationCount.add(temporal)
            }while (cursorGerminationCount.moveToNext())
        }
        cursorGerminationCount.close()
        return listFuzzGerminationCount
    }

    //SELECT BUSCANDO POR ID
    fun getS1GeneralAssessment(id: Int):FuzzGerminationCount?{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        var elemento: FuzzGerminationCount? = null
        var cursorGerminationCount: Cursor? = null

        cursorGerminationCount = db.rawQuery("SELECT * FROM $TABLE_FUZZ_GERMINATION_COUNT WHERE id = $id LIMIT 1", null)
        if (cursorGerminationCount.moveToFirst()){
            elemento = FuzzGerminationCount(
                cursorGerminationCount.getInt(0),
                cursorGerminationCount.getString(1),
                cursorGerminationCount.getString(2),
                cursorGerminationCount.getDouble(3),
                cursorGerminationCount.getString(4),
                cursorGerminationCount.getString(5),
                false
            )
        }
        cursorGerminationCount.close()
        return elemento
    }
}

