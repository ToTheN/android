package com.example.RoomDatabase.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.RoomDatabase.EmployeeDataClass


// Entity means a row
@Database(entities = [EmployeeDataClass::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun employeeDao(): RoomEmployeeDoa
}
