package com.companytest.jsonplaceholderintegration.exception

import java.lang.Exception

class InternetException(var userErrorMessage: String, var technicalError: String = "") : Exception(technicalError) {
}