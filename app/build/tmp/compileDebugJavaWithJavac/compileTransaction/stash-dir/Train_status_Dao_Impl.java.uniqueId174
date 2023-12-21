package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Train_status;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Train_status_Dao_Impl implements Train_status_Dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Train_status> __insertionAdapterOfTrain_status;

  private final EntityDeletionOrUpdateAdapter<Train_status> __deletionAdapterOfTrain_status;

  private final EntityDeletionOrUpdateAdapter<Train_status> __updateAdapterOfTrain_status;

  public Train_status_Dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrain_status = new EntityInsertionAdapter<Train_status>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `train_status` (`id`,`train_id`,`available_date`,`blocked_seats`,`waiting_seats`,`available_seats`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train_status value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        if (value.getAvailable_date() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAvailable_date());
        }
        stmt.bindLong(4, value.getBlocked_seats());
        stmt.bindLong(5, value.getWaiting_seats());
        stmt.bindLong(6, value.getAvailable_seats());
      }
    };
    this.__deletionAdapterOfTrain_status = new EntityDeletionOrUpdateAdapter<Train_status>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `train_status` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train_status value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTrain_status = new EntityDeletionOrUpdateAdapter<Train_status>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `train_status` SET `id` = ?,`train_id` = ?,`available_date` = ?,`blocked_seats` = ?,`waiting_seats` = ?,`available_seats` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train_status value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        if (value.getAvailable_date() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getAvailable_date());
        }
        stmt.bindLong(4, value.getBlocked_seats());
        stmt.bindLong(5, value.getWaiting_seats());
        stmt.bindLong(6, value.getAvailable_seats());
        stmt.bindLong(7, value.getId());
      }
    };
  }

  @Override
  public void insert(final Train_status trainStatus) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrain_status.insert(trainStatus);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Train_status trainStatus) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTrain_status.handle(trainStatus);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Train_status trainStatus) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTrain_status.handle(trainStatus);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Train_status> getAllTrainStatus() {
    final String _sql = "SELECT * FROM train_status";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfAvailableDate = CursorUtil.getColumnIndexOrThrow(_cursor, "available_date");
      final int _cursorIndexOfBlockedSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_seats");
      final int _cursorIndexOfWaitingSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "waiting_seats");
      final int _cursorIndexOfAvailableSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "available_seats");
      final List<Train_status> _result = new ArrayList<Train_status>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Train_status _item;
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final String _tmpAvailable_date;
        if (_cursor.isNull(_cursorIndexOfAvailableDate)) {
          _tmpAvailable_date = null;
        } else {
          _tmpAvailable_date = _cursor.getString(_cursorIndexOfAvailableDate);
        }
        final int _tmpBlocked_seats;
        _tmpBlocked_seats = _cursor.getInt(_cursorIndexOfBlockedSeats);
        final int _tmpWaiting_seats;
        _tmpWaiting_seats = _cursor.getInt(_cursorIndexOfWaitingSeats);
        final int _tmpAvailable_seats;
        _tmpAvailable_seats = _cursor.getInt(_cursorIndexOfAvailableSeats);
        _item = new Train_status(_tmpTrain_id,_tmpAvailable_date,_tmpBlocked_seats,_tmpWaiting_seats,_tmpAvailable_seats);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Train_status getTrainStatusById(final int trainId) {
    final String _sql = "SELECT * FROM train_status WHERE train_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfAvailableDate = CursorUtil.getColumnIndexOrThrow(_cursor, "available_date");
      final int _cursorIndexOfBlockedSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "blocked_seats");
      final int _cursorIndexOfWaitingSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "waiting_seats");
      final int _cursorIndexOfAvailableSeats = CursorUtil.getColumnIndexOrThrow(_cursor, "available_seats");
      final Train_status _result;
      if(_cursor.moveToFirst()) {
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final String _tmpAvailable_date;
        if (_cursor.isNull(_cursorIndexOfAvailableDate)) {
          _tmpAvailable_date = null;
        } else {
          _tmpAvailable_date = _cursor.getString(_cursorIndexOfAvailableDate);
        }
        final int _tmpBlocked_seats;
        _tmpBlocked_seats = _cursor.getInt(_cursorIndexOfBlockedSeats);
        final int _tmpWaiting_seats;
        _tmpWaiting_seats = _cursor.getInt(_cursorIndexOfWaitingSeats);
        final int _tmpAvailable_seats;
        _tmpAvailable_seats = _cursor.getInt(_cursorIndexOfAvailableSeats);
        _result = new Train_status(_tmpTrain_id,_tmpAvailable_date,_tmpBlocked_seats,_tmpWaiting_seats,_tmpAvailable_seats);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
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
