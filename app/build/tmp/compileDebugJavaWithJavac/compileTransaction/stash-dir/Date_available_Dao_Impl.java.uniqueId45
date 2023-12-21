package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Day_available;
import com.example.ck_room.Entity.Train;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Date_available_Dao_Impl implements Date_available_Dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Day_available> __insertionAdapterOfDay_available;

  private final EntityDeletionOrUpdateAdapter<Day_available> __deletionAdapterOfDay_available;

  private final EntityDeletionOrUpdateAdapter<Day_available> __updateAdapterOfDay_available;

  public Date_available_Dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfDay_available = new EntityInsertionAdapter<Day_available>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `day_available` (`id`,`train_id`,`day_available`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Day_available value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        if (value.getDay_available() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDay_available());
        }
      }
    };
    this.__deletionAdapterOfDay_available = new EntityDeletionOrUpdateAdapter<Day_available>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `day_available` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Day_available value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfDay_available = new EntityDeletionOrUpdateAdapter<Day_available>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `day_available` SET `id` = ?,`train_id` = ?,`day_available` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Day_available value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        if (value.getDay_available() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getDay_available());
        }
        stmt.bindLong(4, value.getId());
      }
    };
  }

  @Override
  public void insert(final Day_available dayAvailable) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDay_available.insert(dayAvailable);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Day_available dayAvailable) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfDay_available.handle(dayAvailable);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Day_available dayAvailable) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfDay_available.handle(dayAvailable);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Day_available> getAllDayAvailable() {
    final String _sql = "SELECT * FROM day_available";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfDayAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "day_available");
      final List<Day_available> _result = new ArrayList<Day_available>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Day_available _item;
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final String _tmpDay_available;
        if (_cursor.isNull(_cursorIndexOfDayAvailable)) {
          _tmpDay_available = null;
        } else {
          _tmpDay_available = _cursor.getString(_cursorIndexOfDayAvailable);
        }
        _item = new Day_available(_tmpTrain_id,_tmpDay_available);
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
  public List<Day_available> getDayAvailableByTrainId(final int trainId) {
    final String _sql = "SELECT * FROM day_available WHERE train_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfDayAvailable = CursorUtil.getColumnIndexOrThrow(_cursor, "day_available");
      final List<Day_available> _result = new ArrayList<Day_available>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Day_available _item;
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final String _tmpDay_available;
        if (_cursor.isNull(_cursorIndexOfDayAvailable)) {
          _tmpDay_available = null;
        } else {
          _tmpDay_available = _cursor.getString(_cursorIndexOfDayAvailable);
        }
        _item = new Day_available(_tmpTrain_id,_tmpDay_available);
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
  public Train getTrainClassById(final int trainId) {
    final String _sql = "SELECT * FROM Train WHERE train_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfTrainName = CursorUtil.getColumnIndexOrThrow(_cursor, "Train_name");
      final int _cursorIndexOfSourceStn = CursorUtil.getColumnIndexOrThrow(_cursor, "Source_stn");
      final int _cursorIndexOfDestinationStn = CursorUtil.getColumnIndexOrThrow(_cursor, "Destination_stn");
      final int _cursorIndexOfSourceID = CursorUtil.getColumnIndexOrThrow(_cursor, "Source_ID");
      final int _cursorIndexOfDestinationID = CursorUtil.getColumnIndexOrThrow(_cursor, "Destination_ID");
      final int _cursorIndexOfTimeStart = CursorUtil.getColumnIndexOrThrow(_cursor, "timeStart");
      final int _cursorIndexOfTimeEnd = CursorUtil.getColumnIndexOrThrow(_cursor, "timeEnd");
      final Train _result;
      if(_cursor.moveToFirst()) {
        _result = new Train();
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _result.setTrain_id(_tmpTrain_id);
        final String _tmpTrain_name;
        if (_cursor.isNull(_cursorIndexOfTrainName)) {
          _tmpTrain_name = null;
        } else {
          _tmpTrain_name = _cursor.getString(_cursorIndexOfTrainName);
        }
        _result.setTrain_name(_tmpTrain_name);
        final String _tmpSource_stn;
        if (_cursor.isNull(_cursorIndexOfSourceStn)) {
          _tmpSource_stn = null;
        } else {
          _tmpSource_stn = _cursor.getString(_cursorIndexOfSourceStn);
        }
        _result.setSource_stn(_tmpSource_stn);
        final String _tmpDestination_stn;
        if (_cursor.isNull(_cursorIndexOfDestinationStn)) {
          _tmpDestination_stn = null;
        } else {
          _tmpDestination_stn = _cursor.getString(_cursorIndexOfDestinationStn);
        }
        _result.setDestination_stn(_tmpDestination_stn);
        final int _tmpSource_ID;
        _tmpSource_ID = _cursor.getInt(_cursorIndexOfSourceID);
        _result.setSource_ID(_tmpSource_ID);
        final int _tmpDestination_ID;
        _tmpDestination_ID = _cursor.getInt(_cursorIndexOfDestinationID);
        _result.setDestination_ID(_tmpDestination_ID);
        final String _tmpTimeStart;
        if (_cursor.isNull(_cursorIndexOfTimeStart)) {
          _tmpTimeStart = null;
        } else {
          _tmpTimeStart = _cursor.getString(_cursorIndexOfTimeStart);
        }
        _result.setTimeStart(_tmpTimeStart);
        final String _tmpTimeEnd;
        if (_cursor.isNull(_cursorIndexOfTimeEnd)) {
          _tmpTimeEnd = null;
        } else {
          _tmpTimeEnd = _cursor.getString(_cursorIndexOfTimeEnd);
        }
        _result.setTimeEnd(_tmpTimeEnd);
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
