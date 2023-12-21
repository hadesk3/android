package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Reservation;
import com.example.ck_room.Entity.Train_class;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ReservationDao_Impl implements ReservationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Reservation> __insertionAdapterOfReservation;

  private final EntityDeletionOrUpdateAdapter<Reservation> __deletionAdapterOfReservation;

  private final EntityDeletionOrUpdateAdapter<Reservation> __updateAdapterOfReservation;

  public ReservationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfReservation = new EntityInsertionAdapter<Reservation>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Reservation` (`id`,`PNR`,`Train_Id_class`,`available_date`,`EmailID`,`Reservation_Date`,`Reservation_Status`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Reservation value) {
        stmt.bindLong(1, value.getId());
        if (value.getPNR() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPNR());
        }
        stmt.bindLong(3, value.getTrain_Id_class());
        if (value.getAvailable_date() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAvailable_date());
        }
        if (value.getEmailID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEmailID());
        }
        if (value.getReservation_Date() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReservation_Date());
        }
        if (value.getReservation_Status() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReservation_Status());
        }
      }
    };
    this.__deletionAdapterOfReservation = new EntityDeletionOrUpdateAdapter<Reservation>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Reservation` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Reservation value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfReservation = new EntityDeletionOrUpdateAdapter<Reservation>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Reservation` SET `id` = ?,`PNR` = ?,`Train_Id_class` = ?,`available_date` = ?,`EmailID` = ?,`Reservation_Date` = ?,`Reservation_Status` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Reservation value) {
        stmt.bindLong(1, value.getId());
        if (value.getPNR() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPNR());
        }
        stmt.bindLong(3, value.getTrain_Id_class());
        if (value.getAvailable_date() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getAvailable_date());
        }
        if (value.getEmailID() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getEmailID());
        }
        if (value.getReservation_Date() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getReservation_Date());
        }
        if (value.getReservation_Status() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getReservation_Status());
        }
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void insert(final Reservation reservation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfReservation.insert(reservation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Reservation reservation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfReservation.handle(reservation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Reservation reservation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfReservation.handle(reservation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Reservation> getAllReservations() {
    final String _sql = "SELECT * FROM Reservation";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPNR = CursorUtil.getColumnIndexOrThrow(_cursor, "PNR");
      final int _cursorIndexOfTrainIdClass = CursorUtil.getColumnIndexOrThrow(_cursor, "Train_Id_class");
      final int _cursorIndexOfAvailableDate = CursorUtil.getColumnIndexOrThrow(_cursor, "available_date");
      final int _cursorIndexOfEmailID = CursorUtil.getColumnIndexOrThrow(_cursor, "EmailID");
      final int _cursorIndexOfReservationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Date");
      final int _cursorIndexOfReservationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Status");
      final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Reservation _item;
        _item = new Reservation();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPNR;
        if (_cursor.isNull(_cursorIndexOfPNR)) {
          _tmpPNR = null;
        } else {
          _tmpPNR = _cursor.getString(_cursorIndexOfPNR);
        }
        _item.setPNR(_tmpPNR);
        final int _tmpTrain_Id_class;
        _tmpTrain_Id_class = _cursor.getInt(_cursorIndexOfTrainIdClass);
        _item.setTrain_Id_class(_tmpTrain_Id_class);
        final String _tmpAvailable_date;
        if (_cursor.isNull(_cursorIndexOfAvailableDate)) {
          _tmpAvailable_date = null;
        } else {
          _tmpAvailable_date = _cursor.getString(_cursorIndexOfAvailableDate);
        }
        _item.setAvailable_date(_tmpAvailable_date);
        final String _tmpEmailID;
        if (_cursor.isNull(_cursorIndexOfEmailID)) {
          _tmpEmailID = null;
        } else {
          _tmpEmailID = _cursor.getString(_cursorIndexOfEmailID);
        }
        _item.setEmailID(_tmpEmailID);
        final String _tmpReservation_Date;
        if (_cursor.isNull(_cursorIndexOfReservationDate)) {
          _tmpReservation_Date = null;
        } else {
          _tmpReservation_Date = _cursor.getString(_cursorIndexOfReservationDate);
        }
        _item.setReservation_Date(_tmpReservation_Date);
        final String _tmpReservation_Status;
        if (_cursor.isNull(_cursorIndexOfReservationStatus)) {
          _tmpReservation_Status = null;
        } else {
          _tmpReservation_Status = _cursor.getString(_cursorIndexOfReservationStatus);
        }
        _item.setReservation_Status(_tmpReservation_Status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Reservation getReservationById(final int id) {
    final String _sql = "SELECT * FROM Reservation WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPNR = CursorUtil.getColumnIndexOrThrow(_cursor, "PNR");
      final int _cursorIndexOfTrainIdClass = CursorUtil.getColumnIndexOrThrow(_cursor, "Train_Id_class");
      final int _cursorIndexOfAvailableDate = CursorUtil.getColumnIndexOrThrow(_cursor, "available_date");
      final int _cursorIndexOfEmailID = CursorUtil.getColumnIndexOrThrow(_cursor, "EmailID");
      final int _cursorIndexOfReservationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Date");
      final int _cursorIndexOfReservationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Status");
      final Reservation _result;
      if(_cursor.moveToFirst()) {
        _result = new Reservation();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpPNR;
        if (_cursor.isNull(_cursorIndexOfPNR)) {
          _tmpPNR = null;
        } else {
          _tmpPNR = _cursor.getString(_cursorIndexOfPNR);
        }
        _result.setPNR(_tmpPNR);
        final int _tmpTrain_Id_class;
        _tmpTrain_Id_class = _cursor.getInt(_cursorIndexOfTrainIdClass);
        _result.setTrain_Id_class(_tmpTrain_Id_class);
        final String _tmpAvailable_date;
        if (_cursor.isNull(_cursorIndexOfAvailableDate)) {
          _tmpAvailable_date = null;
        } else {
          _tmpAvailable_date = _cursor.getString(_cursorIndexOfAvailableDate);
        }
        _result.setAvailable_date(_tmpAvailable_date);
        final String _tmpEmailID;
        if (_cursor.isNull(_cursorIndexOfEmailID)) {
          _tmpEmailID = null;
        } else {
          _tmpEmailID = _cursor.getString(_cursorIndexOfEmailID);
        }
        _result.setEmailID(_tmpEmailID);
        final String _tmpReservation_Date;
        if (_cursor.isNull(_cursorIndexOfReservationDate)) {
          _tmpReservation_Date = null;
        } else {
          _tmpReservation_Date = _cursor.getString(_cursorIndexOfReservationDate);
        }
        _result.setReservation_Date(_tmpReservation_Date);
        final String _tmpReservation_Status;
        if (_cursor.isNull(_cursorIndexOfReservationStatus)) {
          _tmpReservation_Status = null;
        } else {
          _tmpReservation_Status = _cursor.getString(_cursorIndexOfReservationStatus);
        }
        _result.setReservation_Status(_tmpReservation_Status);
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
  public List<Reservation> getReservationsByTrainId(final int trainId) {
    final String _sql = "SELECT * FROM Reservation WHERE train_id_class = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPNR = CursorUtil.getColumnIndexOrThrow(_cursor, "PNR");
      final int _cursorIndexOfTrainIdClass = CursorUtil.getColumnIndexOrThrow(_cursor, "Train_Id_class");
      final int _cursorIndexOfAvailableDate = CursorUtil.getColumnIndexOrThrow(_cursor, "available_date");
      final int _cursorIndexOfEmailID = CursorUtil.getColumnIndexOrThrow(_cursor, "EmailID");
      final int _cursorIndexOfReservationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Date");
      final int _cursorIndexOfReservationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Status");
      final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Reservation _item;
        _item = new Reservation();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPNR;
        if (_cursor.isNull(_cursorIndexOfPNR)) {
          _tmpPNR = null;
        } else {
          _tmpPNR = _cursor.getString(_cursorIndexOfPNR);
        }
        _item.setPNR(_tmpPNR);
        final int _tmpTrain_Id_class;
        _tmpTrain_Id_class = _cursor.getInt(_cursorIndexOfTrainIdClass);
        _item.setTrain_Id_class(_tmpTrain_Id_class);
        final String _tmpAvailable_date;
        if (_cursor.isNull(_cursorIndexOfAvailableDate)) {
          _tmpAvailable_date = null;
        } else {
          _tmpAvailable_date = _cursor.getString(_cursorIndexOfAvailableDate);
        }
        _item.setAvailable_date(_tmpAvailable_date);
        final String _tmpEmailID;
        if (_cursor.isNull(_cursorIndexOfEmailID)) {
          _tmpEmailID = null;
        } else {
          _tmpEmailID = _cursor.getString(_cursorIndexOfEmailID);
        }
        _item.setEmailID(_tmpEmailID);
        final String _tmpReservation_Date;
        if (_cursor.isNull(_cursorIndexOfReservationDate)) {
          _tmpReservation_Date = null;
        } else {
          _tmpReservation_Date = _cursor.getString(_cursorIndexOfReservationDate);
        }
        _item.setReservation_Date(_tmpReservation_Date);
        final String _tmpReservation_Status;
        if (_cursor.isNull(_cursorIndexOfReservationStatus)) {
          _tmpReservation_Status = null;
        } else {
          _tmpReservation_Status = _cursor.getString(_cursorIndexOfReservationStatus);
        }
        _item.setReservation_Status(_tmpReservation_Status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Reservation> getReservationsByEmailId(final String emailId) {
    final String _sql = "SELECT * FROM Reservation WHERE EmailID = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (emailId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, emailId);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPNR = CursorUtil.getColumnIndexOrThrow(_cursor, "PNR");
      final int _cursorIndexOfTrainIdClass = CursorUtil.getColumnIndexOrThrow(_cursor, "Train_Id_class");
      final int _cursorIndexOfAvailableDate = CursorUtil.getColumnIndexOrThrow(_cursor, "available_date");
      final int _cursorIndexOfEmailID = CursorUtil.getColumnIndexOrThrow(_cursor, "EmailID");
      final int _cursorIndexOfReservationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Date");
      final int _cursorIndexOfReservationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Status");
      final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Reservation _item;
        _item = new Reservation();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPNR;
        if (_cursor.isNull(_cursorIndexOfPNR)) {
          _tmpPNR = null;
        } else {
          _tmpPNR = _cursor.getString(_cursorIndexOfPNR);
        }
        _item.setPNR(_tmpPNR);
        final int _tmpTrain_Id_class;
        _tmpTrain_Id_class = _cursor.getInt(_cursorIndexOfTrainIdClass);
        _item.setTrain_Id_class(_tmpTrain_Id_class);
        final String _tmpAvailable_date;
        if (_cursor.isNull(_cursorIndexOfAvailableDate)) {
          _tmpAvailable_date = null;
        } else {
          _tmpAvailable_date = _cursor.getString(_cursorIndexOfAvailableDate);
        }
        _item.setAvailable_date(_tmpAvailable_date);
        final String _tmpEmailID;
        if (_cursor.isNull(_cursorIndexOfEmailID)) {
          _tmpEmailID = null;
        } else {
          _tmpEmailID = _cursor.getString(_cursorIndexOfEmailID);
        }
        _item.setEmailID(_tmpEmailID);
        final String _tmpReservation_Date;
        if (_cursor.isNull(_cursorIndexOfReservationDate)) {
          _tmpReservation_Date = null;
        } else {
          _tmpReservation_Date = _cursor.getString(_cursorIndexOfReservationDate);
        }
        _item.setReservation_Date(_tmpReservation_Date);
        final String _tmpReservation_Status;
        if (_cursor.isNull(_cursorIndexOfReservationStatus)) {
          _tmpReservation_Status = null;
        } else {
          _tmpReservation_Status = _cursor.getString(_cursorIndexOfReservationStatus);
        }
        _item.setReservation_Status(_tmpReservation_Status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Reservation> getReservationsByStatus(final String status) {
    final String _sql = "SELECT * FROM Reservation WHERE Reservation_Status = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (status == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, status);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPNR = CursorUtil.getColumnIndexOrThrow(_cursor, "PNR");
      final int _cursorIndexOfTrainIdClass = CursorUtil.getColumnIndexOrThrow(_cursor, "Train_Id_class");
      final int _cursorIndexOfAvailableDate = CursorUtil.getColumnIndexOrThrow(_cursor, "available_date");
      final int _cursorIndexOfEmailID = CursorUtil.getColumnIndexOrThrow(_cursor, "EmailID");
      final int _cursorIndexOfReservationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Date");
      final int _cursorIndexOfReservationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Status");
      final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Reservation _item;
        _item = new Reservation();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPNR;
        if (_cursor.isNull(_cursorIndexOfPNR)) {
          _tmpPNR = null;
        } else {
          _tmpPNR = _cursor.getString(_cursorIndexOfPNR);
        }
        _item.setPNR(_tmpPNR);
        final int _tmpTrain_Id_class;
        _tmpTrain_Id_class = _cursor.getInt(_cursorIndexOfTrainIdClass);
        _item.setTrain_Id_class(_tmpTrain_Id_class);
        final String _tmpAvailable_date;
        if (_cursor.isNull(_cursorIndexOfAvailableDate)) {
          _tmpAvailable_date = null;
        } else {
          _tmpAvailable_date = _cursor.getString(_cursorIndexOfAvailableDate);
        }
        _item.setAvailable_date(_tmpAvailable_date);
        final String _tmpEmailID;
        if (_cursor.isNull(_cursorIndexOfEmailID)) {
          _tmpEmailID = null;
        } else {
          _tmpEmailID = _cursor.getString(_cursorIndexOfEmailID);
        }
        _item.setEmailID(_tmpEmailID);
        final String _tmpReservation_Date;
        if (_cursor.isNull(_cursorIndexOfReservationDate)) {
          _tmpReservation_Date = null;
        } else {
          _tmpReservation_Date = _cursor.getString(_cursorIndexOfReservationDate);
        }
        _item.setReservation_Date(_tmpReservation_Date);
        final String _tmpReservation_Status;
        if (_cursor.isNull(_cursorIndexOfReservationStatus)) {
          _tmpReservation_Status = null;
        } else {
          _tmpReservation_Status = _cursor.getString(_cursorIndexOfReservationStatus);
        }
        _item.setReservation_Status(_tmpReservation_Status);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Reservation> getReservationsByDate(final String date) {
    final String _sql = "SELECT * FROM Reservation WHERE Available_Date = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (date == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, date);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfPNR = CursorUtil.getColumnIndexOrThrow(_cursor, "PNR");
      final int _cursorIndexOfTrainIdClass = CursorUtil.getColumnIndexOrThrow(_cursor, "Train_Id_class");
      final int _cursorIndexOfAvailableDate = CursorUtil.getColumnIndexOrThrow(_cursor, "available_date");
      final int _cursorIndexOfEmailID = CursorUtil.getColumnIndexOrThrow(_cursor, "EmailID");
      final int _cursorIndexOfReservationDate = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Date");
      final int _cursorIndexOfReservationStatus = CursorUtil.getColumnIndexOrThrow(_cursor, "Reservation_Status");
      final List<Reservation> _result = new ArrayList<Reservation>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Reservation _item;
        _item = new Reservation();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpPNR;
        if (_cursor.isNull(_cursorIndexOfPNR)) {
          _tmpPNR = null;
        } else {
          _tmpPNR = _cursor.getString(_cursorIndexOfPNR);
        }
        _item.setPNR(_tmpPNR);
        final int _tmpTrain_Id_class;
        _tmpTrain_Id_class = _cursor.getInt(_cursorIndexOfTrainIdClass);
        _item.setTrain_Id_class(_tmpTrain_Id_class);
        final String _tmpAvailable_date;
        if (_cursor.isNull(_cursorIndexOfAvailableDate)) {
          _tmpAvailable_date = null;
        } else {
          _tmpAvailable_date = _cursor.getString(_cursorIndexOfAvailableDate);
        }
        _item.setAvailable_date(_tmpAvailable_date);
        final String _tmpEmailID;
        if (_cursor.isNull(_cursorIndexOfEmailID)) {
          _tmpEmailID = null;
        } else {
          _tmpEmailID = _cursor.getString(_cursorIndexOfEmailID);
        }
        _item.setEmailID(_tmpEmailID);
        final String _tmpReservation_Date;
        if (_cursor.isNull(_cursorIndexOfReservationDate)) {
          _tmpReservation_Date = null;
        } else {
          _tmpReservation_Date = _cursor.getString(_cursorIndexOfReservationDate);
        }
        _item.setReservation_Date(_tmpReservation_Date);
        final String _tmpReservation_Status;
        if (_cursor.isNull(_cursorIndexOfReservationStatus)) {
          _tmpReservation_Status = null;
        } else {
          _tmpReservation_Status = _cursor.getString(_cursorIndexOfReservationStatus);
        }
        _item.setReservation_Status(_tmpReservation_Status);
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
