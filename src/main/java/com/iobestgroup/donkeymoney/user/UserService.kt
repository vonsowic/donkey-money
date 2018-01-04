package com.iobestgroup.donkeymoney.user

import com.iobestgroup.donkeymoney.user.exceptions.UserAlreadyExistsException
import com.iobestgroup.donkeymoney.user.exceptions.UserNotAuthorizedException
import org.mindrot.jbcrypt.BCrypt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class UserService @Autowired
constructor(private val userDao: UserRepository) {

    /**
     * @param potentialUser
     * @return potentialUser with id.
     * @throws UserAlreadyExistsException
     */
    @Throws(UserAlreadyExistsException::class)
    fun save(potentialUser: DMUser): DMUser = try {
            potentialUser.password = BCrypt.hashpw(potentialUser.password, BCrypt.gensalt())
            userDao.save(potentialUser)
        } catch (e: DataIntegrityViolationException) {
            throw UserAlreadyExistsException()
    }

    fun findByEmail(email: String) = userDao.findByEmail(email)

    fun getSecurityToken(userName: String, password: String) = try{
        userDao.getSecurityToken(
                userName,
                BCrypt.hashpw(password, BCrypt.gensalt())
        ).securityToken
    } catch (_ : IndexOutOfBoundsException ){
        throw UserNotAuthorizedException()
    }

    fun findAll(): Iterable<DMUser> = userDao.findAll()

}


