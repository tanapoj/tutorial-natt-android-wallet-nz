package com.tamemo.mywallet.repository

import com.tamemo.mywallet.database.entities.UserEntity
import io.reactivex.Single

class UserRepository {

    fun getUserById(id: Int): Single<UserEntity>{
        return Single.just(UserEntity(1, "ta@tamemo.com", "", "Ta", "Cai", 0, 0))
    }

}