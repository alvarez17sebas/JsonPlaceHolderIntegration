package com.companytest.jsonplaceholderintegration.repository

import com.companytest.jsonplaceholderintegration.model.Address
import com.companytest.jsonplaceholderintegration.model.Company
import com.companytest.jsonplaceholderintegration.model.Geo
import com.companytest.jsonplaceholderintegration.model.User

class FakeUserRemoteRepository : RemoteRepository<User> {

    override suspend fun getAll(): ArrayList<User> {
        var users: ArrayList<User> = ArrayList()

        var geo: Geo = Geo(1.0, 2.0)

        var address: Address = Address("clle 5", "suite", "Medellin", "2020", geo)

        var company: Company = Company("Capiro", "catch phrase", "bs nn")

        var user: User = User(1, "Sebastian Alvarez", "salvarez",
            "sebastian17.alvarez@gmail.com", address, "3116691431", "www.notengo.com", company)

        users.add(user)

        return users
    }

    override suspend fun getById(id: String): User {

        var geo: Geo = Geo(1.0, 2.0)

        var address: Address = Address("clle 5", "suite", "Medellin", "2020", geo)

        var company: Company = Company("Capiro", "catch phrase", "bs nn")

        var user: User = User(1, "Sebastian Alvarez", "salvarez",
            "sebastian17.alvarez@gmail.com", address, "3116691431", "www.notengo.com", company)

        return user
    }
}