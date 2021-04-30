package com.example.employeeslist.data

import androidx.lifecycle.LiveData

class EmployeeRepository(private val employeeDao: EmployeeDao) {

    val readAllData: LiveData<List<Employee>> = employeeDao.readAllData()

    suspend fun addEmployee(employee: Employee) {
        employeeDao.addEmployee(employee)
    }
}