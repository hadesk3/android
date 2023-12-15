package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.User;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `user` (`EmailID`,`firstName`,`lastName`,`pass`,`phone`,`dob`,`gender`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUserName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserName());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName());
        }
        if (value.getPass() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPass());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPhone());
        }
        if (value.getDob() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDob());
        }
        if (value.getGender() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGender());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `user` WHERE `EmailID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUserName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserName());
        }
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `user` SET `EmailID` = ?,`firstName` = ?,`lastName` = ?,`pass` = ?,`phone` = ?,`dob` = ?,`gender` = ? WHERE `EmailID` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        if (value.getUserName() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getUserName());
        }
        if (value.getFirstName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getFirstName());
        }
        if (value.getLastName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLastName());
        }
        if (value.getPass() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPass());
        }
        if (value.getPhone() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getPhone());
        }
        if (value.getDob() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDob());
        }
        if (value.getGender() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getGender());
        }
        if (value.getUserName() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getUserName());
        }
      }
    };
  }

  @Override
  public void insert(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public User getUserByMail(final String userName) {
    final String _sql = "SELECT * FROM user WHERE EmailID= ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (userName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, userName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "EmailID");
      final int _cursorIndexOfFirstName = CursorUtil.getColumnIndexOrThrow(_cursor, "firstName");
      final int _cursorIndexOfLastName = CursorUtil.getColumnIndexOrThrow(_cursor, "lastName");
      final int _cursorIndexOfPass = CursorUtil.getColumnIndexOrThrow(_cursor, "pass");
      final int _cursorIndexOfPhone = CursorUtil.getColumnIndexOrThrow(_cursor, "phone");
      final int _cursorIndexOfDob = CursorUtil.getColumnIndexOrThrow(_cursor, "dob");
      final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
      final User _result;
      if(_cursor.moveToFirst()) {
        _result = new User();
        final String _tmpUserName;
        if (_cursor.isNull(_cursorIndexOfUserName)) {
          _tmpUserName = null;
        } else {
          _tmpUserName = _cursor.getString(_cursorIndexOfUserName);
        }
        _result.setUserName(_tmpUserName);
        final String _tmpFirstName;
        if (_cursor.isNull(_cursorIndexOfFirstName)) {
          _tmpFirstName = null;
        } else {
          _tmpFirstName = _cursor.getString(_cursorIndexOfFirstName);
        }
        _result.setFirstName(_tmpFirstName);
        final String _tmpLastName;
        if (_cursor.isNull(_cursorIndexOfLastName)) {
          _tmpLastName = null;
        } else {
          _tmpLastName = _cursor.getString(_cursorIndexOfLastName);
        }
        _result.setLastName(_tmpLastName);
        final String _tmpPass;
        if (_cursor.isNull(_cursorIndexOfPass)) {
          _tmpPass = null;
        } else {
          _tmpPass = _cursor.getString(_cursorIndexOfPass);
        }
        _result.setPass(_tmpPass);
        final String _tmpPhone;
        if (_cursor.isNull(_cursorIndexOfPhone)) {
          _tmpPhone = null;
        } else {
          _tmpPhone = _cursor.getString(_cursorIndexOfPhone);
        }
        _result.setPhone(_tmpPhone);
        final String _tmpDob;
        if (_cursor.isNull(_cursorIndexOfDob)) {
          _tmpDob = null;
        } else {
          _tmpDob = _cursor.getString(_cursorIndexOfDob);
        }
        _result.setDob(_tmpDob);
        final String _tmpGender;
        if (_cursor.isNull(_cursorIndexOfGender)) {
          _tmpGender = null;
        } else {
          _tmpGender = _cursor.getString(_cursorIndexOfGender);
        }
        _result.setGender(_tmpGender);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
