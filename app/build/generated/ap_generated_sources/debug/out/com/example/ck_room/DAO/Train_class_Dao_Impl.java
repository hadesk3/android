package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Train_class;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Train_class_Dao_Impl implements Train_class_Dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Train_class> __insertionAdapterOfTrain_class;

  private final EntityDeletionOrUpdateAdapter<Train_class> __deletionAdapterOfTrain_class;

  private final EntityDeletionOrUpdateAdapter<Train_class> __updateAdapterOfTrain_class;

  public Train_class_Dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrain_class = new EntityInsertionAdapter<Train_class>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Train_class` (`id`,`train_id`,`Economy_Fare`,`Economy_Passenger`,`Business_Fare`,`Business_Passenger`,`First_Fare`,`First_Passenger`,`takenSeats_Economy`,`takenSeats_Business`,`takenSeats_First`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train_class value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        stmt.bindDouble(3, value.getEconomy_Fare());
        stmt.bindLong(4, value.getEconomy_Passenger());
        stmt.bindDouble(5, value.getBusiness_Fare());
        stmt.bindLong(6, value.getBusiness_Passenger());
        stmt.bindDouble(7, value.getFirst_Fare());
        stmt.bindLong(8, value.getFirst_Passenger());
        if (value.getTakenSeats_Economy() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTakenSeats_Economy());
        }
        if (value.getTakenSeats_Business() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTakenSeats_Business());
        }
        if (value.getTakenSeats_First() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTakenSeats_First());
        }
      }
    };
    this.__deletionAdapterOfTrain_class = new EntityDeletionOrUpdateAdapter<Train_class>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Train_class` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train_class value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTrain_class = new EntityDeletionOrUpdateAdapter<Train_class>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Train_class` SET `id` = ?,`train_id` = ?,`Economy_Fare` = ?,`Economy_Passenger` = ?,`Business_Fare` = ?,`Business_Passenger` = ?,`First_Fare` = ?,`First_Passenger` = ?,`takenSeats_Economy` = ?,`takenSeats_Business` = ?,`takenSeats_First` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train_class value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        stmt.bindDouble(3, value.getEconomy_Fare());
        stmt.bindLong(4, value.getEconomy_Passenger());
        stmt.bindDouble(5, value.getBusiness_Fare());
        stmt.bindLong(6, value.getBusiness_Passenger());
        stmt.bindDouble(7, value.getFirst_Fare());
        stmt.bindLong(8, value.getFirst_Passenger());
        if (value.getTakenSeats_Economy() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTakenSeats_Economy());
        }
        if (value.getTakenSeats_Business() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindString(10, value.getTakenSeats_Business());
        }
        if (value.getTakenSeats_First() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindString(11, value.getTakenSeats_First());
        }
        stmt.bindLong(12, value.getId());
      }
    };
  }

  @Override
  public void insert(final Train_class trainClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrain_class.insert(trainClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Train_class trainClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTrain_class.handle(trainClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Train_class trainClass) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTrain_class.handle(trainClass);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Train_class> getAllTrainClasses() {
    final String _sql = "SELECT * FROM Train_class";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfEconomyFare = CursorUtil.getColumnIndexOrThrow(_cursor, "Economy_Fare");
      final int _cursorIndexOfEconomyPassenger = CursorUtil.getColumnIndexOrThrow(_cursor, "Economy_Passenger");
      final int _cursorIndexOfBusinessFare = CursorUtil.getColumnIndexOrThrow(_cursor, "Business_Fare");
      final int _cursorIndexOfBusinessPassenger = CursorUtil.getColumnIndexOrThrow(_cursor, "Business_Passenger");
      final int _cursorIndexOfFirstFare = CursorUtil.getColumnIndexOrThrow(_cursor, "First_Fare");
      final int _cursorIndexOfFirstPassenger = CursorUtil.getColumnIndexOrThrow(_cursor, "First_Passenger");
      final int _cursorIndexOfTakenSeatsEconomy = CursorUtil.getColumnIndexOrThrow(_cursor, "takenSeats_Economy");
      final int _cursorIndexOfTakenSeatsBusiness = CursorUtil.getColumnIndexOrThrow(_cursor, "takenSeats_Business");
      final int _cursorIndexOfTakenSeatsFirst = CursorUtil.getColumnIndexOrThrow(_cursor, "takenSeats_First");
      final List<Train_class> _result = new ArrayList<Train_class>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Train_class _item;
        _item = new Train_class();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final double _tmpEconomy_Fare;
        _tmpEconomy_Fare = _cursor.getDouble(_cursorIndexOfEconomyFare);
        _item.setEconomy_Fare(_tmpEconomy_Fare);
        final int _tmpEconomy_Passenger;
        _tmpEconomy_Passenger = _cursor.getInt(_cursorIndexOfEconomyPassenger);
        _item.setEconomy_Passenger(_tmpEconomy_Passenger);
        final double _tmpBusiness_Fare;
        _tmpBusiness_Fare = _cursor.getDouble(_cursorIndexOfBusinessFare);
        _item.setBusiness_Fare(_tmpBusiness_Fare);
        final int _tmpBusiness_Passenger;
        _tmpBusiness_Passenger = _cursor.getInt(_cursorIndexOfBusinessPassenger);
        _item.setBusiness_Passenger(_tmpBusiness_Passenger);
        final double _tmpFirst_Fare;
        _tmpFirst_Fare = _cursor.getDouble(_cursorIndexOfFirstFare);
        _item.setFirst_Fare(_tmpFirst_Fare);
        final int _tmpFirst_Passenger;
        _tmpFirst_Passenger = _cursor.getInt(_cursorIndexOfFirstPassenger);
        _item.setFirst_Passenger(_tmpFirst_Passenger);
        final String _tmpTakenSeats_Economy;
        if (_cursor.isNull(_cursorIndexOfTakenSeatsEconomy)) {
          _tmpTakenSeats_Economy = null;
        } else {
          _tmpTakenSeats_Economy = _cursor.getString(_cursorIndexOfTakenSeatsEconomy);
        }
        _item.setTakenSeats_Economy(_tmpTakenSeats_Economy);
        final String _tmpTakenSeats_Business;
        if (_cursor.isNull(_cursorIndexOfTakenSeatsBusiness)) {
          _tmpTakenSeats_Business = null;
        } else {
          _tmpTakenSeats_Business = _cursor.getString(_cursorIndexOfTakenSeatsBusiness);
        }
        _item.setTakenSeats_Business(_tmpTakenSeats_Business);
        final String _tmpTakenSeats_First;
        if (_cursor.isNull(_cursorIndexOfTakenSeatsFirst)) {
          _tmpTakenSeats_First = null;
        } else {
          _tmpTakenSeats_First = _cursor.getString(_cursorIndexOfTakenSeatsFirst);
        }
        _item.setTakenSeats_First(_tmpTakenSeats_First);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Train_class getTrainClassById(final int trainId) {
    final String _sql = "SELECT * FROM Train_class WHERE train_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfEconomyFare = CursorUtil.getColumnIndexOrThrow(_cursor, "Economy_Fare");
      final int _cursorIndexOfEconomyPassenger = CursorUtil.getColumnIndexOrThrow(_cursor, "Economy_Passenger");
      final int _cursorIndexOfBusinessFare = CursorUtil.getColumnIndexOrThrow(_cursor, "Business_Fare");
      final int _cursorIndexOfBusinessPassenger = CursorUtil.getColumnIndexOrThrow(_cursor, "Business_Passenger");
      final int _cursorIndexOfFirstFare = CursorUtil.getColumnIndexOrThrow(_cursor, "First_Fare");
      final int _cursorIndexOfFirstPassenger = CursorUtil.getColumnIndexOrThrow(_cursor, "First_Passenger");
      final int _cursorIndexOfTakenSeatsEconomy = CursorUtil.getColumnIndexOrThrow(_cursor, "takenSeats_Economy");
      final int _cursorIndexOfTakenSeatsBusiness = CursorUtil.getColumnIndexOrThrow(_cursor, "takenSeats_Business");
      final int _cursorIndexOfTakenSeatsFirst = CursorUtil.getColumnIndexOrThrow(_cursor, "takenSeats_First");
      final Train_class _result;
      if(_cursor.moveToFirst()) {
        _result = new Train_class();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _result.setTrain_id(_tmpTrain_id);
        final double _tmpEconomy_Fare;
        _tmpEconomy_Fare = _cursor.getDouble(_cursorIndexOfEconomyFare);
        _result.setEconomy_Fare(_tmpEconomy_Fare);
        final int _tmpEconomy_Passenger;
        _tmpEconomy_Passenger = _cursor.getInt(_cursorIndexOfEconomyPassenger);
        _result.setEconomy_Passenger(_tmpEconomy_Passenger);
        final double _tmpBusiness_Fare;
        _tmpBusiness_Fare = _cursor.getDouble(_cursorIndexOfBusinessFare);
        _result.setBusiness_Fare(_tmpBusiness_Fare);
        final int _tmpBusiness_Passenger;
        _tmpBusiness_Passenger = _cursor.getInt(_cursorIndexOfBusinessPassenger);
        _result.setBusiness_Passenger(_tmpBusiness_Passenger);
        final double _tmpFirst_Fare;
        _tmpFirst_Fare = _cursor.getDouble(_cursorIndexOfFirstFare);
        _result.setFirst_Fare(_tmpFirst_Fare);
        final int _tmpFirst_Passenger;
        _tmpFirst_Passenger = _cursor.getInt(_cursorIndexOfFirstPassenger);
        _result.setFirst_Passenger(_tmpFirst_Passenger);
        final String _tmpTakenSeats_Economy;
        if (_cursor.isNull(_cursorIndexOfTakenSeatsEconomy)) {
          _tmpTakenSeats_Economy = null;
        } else {
          _tmpTakenSeats_Economy = _cursor.getString(_cursorIndexOfTakenSeatsEconomy);
        }
        _result.setTakenSeats_Economy(_tmpTakenSeats_Economy);
        final String _tmpTakenSeats_Business;
        if (_cursor.isNull(_cursorIndexOfTakenSeatsBusiness)) {
          _tmpTakenSeats_Business = null;
        } else {
          _tmpTakenSeats_Business = _cursor.getString(_cursorIndexOfTakenSeatsBusiness);
        }
        _result.setTakenSeats_Business(_tmpTakenSeats_Business);
        final String _tmpTakenSeats_First;
        if (_cursor.isNull(_cursorIndexOfTakenSeatsFirst)) {
          _tmpTakenSeats_First = null;
        } else {
          _tmpTakenSeats_First = _cursor.getString(_cursorIndexOfTakenSeatsFirst);
        }
        _result.setTakenSeats_First(_tmpTakenSeats_First);
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
