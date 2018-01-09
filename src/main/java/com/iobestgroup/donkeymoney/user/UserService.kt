package com.iobestgroup.donkeymoney.user

import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException
import com.iobestgroup.donkeymoney.user.exceptions.UserDoesNotExistException
import com.iobestgroup.donkeymoney.user.exceptions.UserNotAuthorizedException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(private val userDao: UserRepository) {

    /**
     * @param potentialUser
     * @return potentialUser with id.
     * @throws UserAlreadyExistsException
     */
    fun save(potentialUser: DMUser): DMUser = try {
//            potentialUser.password = BCrypt.hashpw(potentialUser.password, BCrypt.gensalt())
            userDao.save(potentialUser)
        } catch (e: DataIntegrityViolationException) {
            throw UserAlreadyExistsException()
    }


    fun findByEmail(email: String) = userDao.findByEmail(email)

    fun getSecurityToken(userName: String, password: String) = try {
        """
        |{
        |   "securityToken": "${userDao.getSecurityToken(userName, password).first().securityToken}"
        |}
        """.trimMargin()
    } catch (_ : NoSuchElementException){
        throw UserNotAuthorizedException()
    }


    fun findAll(): Iterable<DMUser> = userDao.findAll()


    fun update(user: DMUser) {
        try {
            val userToBeUpdated = userDao.findByEmail(user.email)
            userToBeUpdated.securityToken = user.securityToken
            userToBeUpdated.email = user.email
            userToBeUpdated.name = user.name
            userToBeUpdated.lastName = user.lastName
            userDao.save(userToBeUpdated)
        } catch (_: Exception){
            throw UserDoesNotExistException()
        }
    }

    fun deleteAll() {
        userDao.deleteAll()
    }
}


