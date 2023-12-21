package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Passenger;
import com.example.ck_room.Entity.Train;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class PassengerDao_Impl implements PassengerDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Passenger> __insertionAdapterOfPassenger;

  private final EntityDeletionOrUpdateAdapter<Passenger> __deletionAdapterOfPassenger;

  private final EntityDeletionOrUpdateAdapter<Passenger> __updateAdapterOfPassenger;

  public PassengerDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPassenger = new EntityInsertionAdapter<Passenger>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `passenger` (`pnr`,`seatNumber`,`passengerName`,`age`,`gender`,`train_id`,`origin`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Passenger value) {
        if (value.getPnr() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPnr());
        }
        stmt.bindLong(2, value.getSeatNumber());
        if (value.getPassengerName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassengerName());
        }
        stmt.bindLong(4, value.getAge());
        if (value.getGender() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGender());
        }
        stmt.bindLong(6, value.getTrain_id());
        if (value.getOrigin() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOrigin());
        }
      }
    };
    this.__deletionAdapterOfPassenger = new EntityDeletionOrUpdateAdapter<Passenger>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `passenger` WHERE `pnr` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Passenger value) {
        if (value.getPnr() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPnr());
        }
      }
    };
    this.__updateAdapterOfPassenger = new EntityDeletionOrUpdateAdapter<Passenger>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `passenger` SET `pnr` = ?,`seatNumber` = ?,`passengerName` = ?,`age` = ?,`gender` = ?,`train_id` = ?,`origin` = ? WHERE `pnr` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Passenger value) {
        if (value.getPnr() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getPnr());
        }
        stmt.bindLong(2, value.getSeatNumber());
        if (value.getPassengerName() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassengerName());
        }
        stmt.bindLong(4, value.getAge());
        if (value.getGender() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getGender());
        }
        stmt.bindLong(6, value.getTrain_id());
        if (value.getOrigin() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getOrigin());
        }
        if (value.getPnr() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getPnr());
        }
      }
    };
  }

  @Override
  public void insert(final Passenger passenger) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPassenger.insert(passenger);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Passenger passenger) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPassenger.handle(passenger);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Passenger passenger) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPassenger.handle(passenger);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Passenger> getAllPassengers() {
    final String _sql = "SELECT * FROM passenger";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPnr = CursorUtil.getColumnIndexOrThrow(_cursor, "pnr");
      final int _cursorIndexOfSeatNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "seatNumber");
      final int _cursorIndexOfPassengerName = CursorUtil.getColumnIndexOrThrow(_cursor, "passengerName");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "origin");
      final List<Passenger> _result = new ArrayList<Passenger>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Passenger _item;
        final String _tmpPnr;
        if (_cursor.isNull(_cursorIndexOfPnr)) {
          _tmpPnr = null;
        } else {
          _tmpPnr = _cursor.getString(_cursorIndexOfPnr);
        }
        final int _tmpSeatNumber;
        _tmpSeatNumber = _cursor.getInt(_cursorIndexOfSeatNumber);
        final String _tmpPassengerName;
        if (_cursor.isNull(_cursorIndexOfPassengerName)) {
          _tmpPassengerName = null;
        } else {
          _tmpPassengerName = _cursor.getString(_cursorIndexOfPassengerName);
        }
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        final String _tmpGender;
        if (_cursor.isNull(_cursorIndexOfGender)) {
          _tmpGender = null;
        } else {
          _tmpGender = _cursor.getString(_cursorIndexOfGender);
        }
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final String _tmpOrigin;
        if (_cursor.isNull(_cursorIndexOfOrigin)) {
          _tmpOrigin = null;
        } else {
          _tmpOrigin = _cursor.getString(_cursorIndexOfOrigin);
        }
        _item = new Passenger(_tmpPnr,_tmpSeatNumber,_tmpPassengerName,_tmpAge,_tmpGender,_tmpTrain_id,_tmpOrigin);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Passenger getPassengerByPnr(final String pnr) {
    final String _sql = "SELECT * FROM passenger WHERE pnr = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (pnr == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, pnr);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPnr = CursorUtil.getColumnIndexOrThrow(_cursor, "pnr");
      final int _cursorIndexOfSeatNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "seatNumber");
      final int _cursorIndexOfPassengerName = CursorUtil.getColumnIndexOrThrow(_cursor, "passengerName");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "origin");
      final Passenger _result;
      if(_cursor.moveToFirst()) {
        final String _tmpPnr;
        if (_cursor.isNull(_cursorIndexOfPnr)) {
          _tmpPnr = null;
        } else {
          _tmpPnr = _cursor.getString(_cursorIndexOfPnr);
        }
        final int _tmpSeatNumber;
        _tmpSeatNumber = _cursor.getInt(_cursorIndexOfSeatNumber);
        final String _tmpPassengerName;
        if (_cursor.isNull(_cursorIndexOfPassengerName)) {
          _tmpPassengerName = null;
        } else {
          _tmpPassengerName = _cursor.getString(_cursorIndexOfPassengerName);
        }
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        final String _tmpGender;
        if (_cursor.isNull(_cursorIndexOfGender)) {
          _tmpGender = null;
        } else {
          _tmpGender = _cursor.getString(_cursorIndexOfGender);
        }
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final String _tmpOrigin;
        if (_cursor.isNull(_cursorIndexOfOrigin)) {
          _tmpOrigin = null;
        } else {
          _tmpOrigin = _cursor.getString(_cursorIndexOfOrigin);
        }
        _result = new Passenger(_tmpPnr,_tmpSeatNumber,_tmpPassengerName,_tmpAge,_tmpGender,_tmpTrain_id,_tmpOrigin);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Passenger> getPassengersByTrainId(final int trainId) {
    final String _sql = "SELECT * FROM passenger WHERE train_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfPnr = CursorUtil.getColumnIndexOrThrow(_cursor, "pnr");
      final int _cursorIndexOfSeatNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "seatNumber");
      final int _cursorIndexOfPassengerName = CursorUtil.getColumnIndexOrThrow(_cursor, "passengerName");
      final int _cursorIndexOfAge = CursorUtil.getColumnIndexOrThrow(_cursor, "age");
      final int _cursorIndexOfGender = CursorUtil.getColumnIndexOrThrow(_cursor, "gender");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfOrigin = CursorUtil.getColumnIndexOrThrow(_cursor, "origin");
      final List<Passenger> _result = new ArrayList<Passenger>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Passenger _item;
        final String _tmpPnr;
        if (_cursor.isNull(_cursorIndexOfPnr)) {
          _tmpPnr = null;
        } else {
          _tmpPnr = _cursor.getString(_cursorIndexOfPnr);
        }
        final int _tmpSeatNumber;
        _tmpSeatNumber = _cursor.getInt(_cursorIndexOfSeatNumber);
        final String _tmpPassengerName;
        if (_cursor.isNull(_cursorIndexOfPassengerName)) {
          _tmpPassengerName = null;
        } else {
          _tmpPassengerName = _cursor.getString(_cursorIndexOfPassengerName);
        }
        final int _tmpAge;
        _tmpAge = _cursor.getInt(_cursorIndexOfAge);
        final String _tmpGender;
        if (_cursor.isNull(_cursorIndexOfGender)) {
          _tmpGender = null;
        } else {
          _tmpGender = _cursor.getString(_cursorIndexOfGender);
        }
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final String _tmpOrigin;
        if (_cursor.isNull(_cursorIndexOfOrigin)) {
          _tmpOrigin = null;
        } else {
          _tmpOrigin = _cursor.getString(_cursorIndexOfOrigin);
        }
        _item = new Passenger(_tmpPnr,_tmpSeatNumber,_tmpPassengerName,_tmpAge,_tmpGender,_tmpTrain_id,_tmpOrigin);
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
