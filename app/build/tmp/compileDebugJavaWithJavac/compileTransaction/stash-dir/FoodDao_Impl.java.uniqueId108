package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Food;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class FoodDao_Impl implements FoodDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Food> __insertionAdapterOfFood;

  private final EntityDeletionOrUpdateAdapter<Food> __deletionAdapterOfFood;

  private final EntityDeletionOrUpdateAdapter<Food> __updateAdapterOfFood;

  public FoodDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFood = new EntityInsertionAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Food` (`id`,`name`,`type`,`price`,`drawable`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPrice());
        }
        if (value.getDrawable() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDrawable());
        }
      }
    };
    this.__deletionAdapterOfFood = new EntityDeletionOrUpdateAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Food` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfFood = new EntityDeletionOrUpdateAdapter<Food>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Food` SET `id` = ?,`name` = ?,`type` = ?,`price` = ?,`drawable` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Food value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        if (value.getType() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getType());
        }
        if (value.getPrice() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getPrice());
        }
        if (value.getDrawable() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDrawable());
        }
        stmt.bindLong(6, value.getId());
      }
    };
  }

  @Override
  public long insert(final Food food) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfFood.insertAndReturnId(food);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Food food) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFood.handle(food);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Food food) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfFood.handle(food);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Food> getAllFood() {
    final String _sql = "SELECT * FROM Food";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
      final int _cursorIndexOfPrice = CursorUtil.getColumnIndexOrThrow(_cursor, "price");
      final int _cursorIndexOfDrawable = CursorUtil.getColumnIndexOrThrow(_cursor, "drawable");
      final List<Food> _result = new ArrayList<Food>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Food _item;
        _item = new Food();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        final String _tmpType;
        if (_cursor.isNull(_cursorIndexOfType)) {
          _tmpType = null;
        } else {
          _tmpType = _cursor.getString(_cursorIndexOfType);
        }
        _item.setType(_tmpType);
        final String _tmpPrice;
        if (_cursor.isNull(_cursorIndexOfPrice)) {
          _tmpPrice = null;
        } else {
          _tmpPrice = _cursor.getString(_cursorIndexOfPrice);
        }
        _item.setPrice(_tmpPrice);
        final String _tmpDrawable;
        if (_cursor.isNull(_cursorIndexOfDrawable)) {
          _tmpDrawable = null;
        } else {
          _tmpDrawable = _cursor.getString(_cursorIndexOfDrawable);
        }
        _item.setDrawable(_tmpDrawable);
        _result.add(_item);
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
