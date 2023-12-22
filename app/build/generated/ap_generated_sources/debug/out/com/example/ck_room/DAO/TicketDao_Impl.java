package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Ticket;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TicketDao_Impl implements TicketDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Ticket> __insertionAdapterOfTicket;

  private final EntityDeletionOrUpdateAdapter<Ticket> __deletionAdapterOfTicket;

  private final EntityDeletionOrUpdateAdapter<Ticket> __updateAdapterOfTicket;

  public TicketDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTicket = new EntityInsertionAdapter<Ticket>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Ticket` (`Ticket_No`,`Passenger_Name`,`source`,`destination`,`classType`,`train_id`,`date`,`seat`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ticket value) {
        if (value.getTicket_No() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTicket_No());
        }
        if (value.getPassenger_Name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPassenger_Name());
        }
        if (value.getSource() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSource());
        }
        if (value.getDestination() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDestination());
        }
        if (value.getClassType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getClassType());
        }
        stmt.bindLong(6, value.getTrain_id());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getSeat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSeat());
        }
      }
    };
    this.__deletionAdapterOfTicket = new EntityDeletionOrUpdateAdapter<Ticket>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Ticket` WHERE `Ticket_No` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ticket value) {
        if (value.getTicket_No() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTicket_No());
        }
      }
    };
    this.__updateAdapterOfTicket = new EntityDeletionOrUpdateAdapter<Ticket>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Ticket` SET `Ticket_No` = ?,`Passenger_Name` = ?,`source` = ?,`destination` = ?,`classType` = ?,`train_id` = ?,`date` = ?,`seat` = ? WHERE `Ticket_No` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Ticket value) {
        if (value.getTicket_No() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTicket_No());
        }
        if (value.getPassenger_Name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getPassenger_Name());
        }
        if (value.getSource() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSource());
        }
        if (value.getDestination() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDestination());
        }
        if (value.getClassType() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getClassType());
        }
        stmt.bindLong(6, value.getTrain_id());
        if (value.getDate() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getDate());
        }
        if (value.getSeat() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getSeat());
        }
        if (value.getTicket_No() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getTicket_No());
        }
      }
    };
  }

  @Override
  public void insert(final Ticket ticket) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTicket.insert(ticket);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Ticket ticket) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTicket.handle(ticket);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Ticket ticket) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTicket.handle(ticket);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Ticket> getAllTickets() {
    final String _sql = "SELECT * FROM Ticket";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTicketNo = CursorUtil.getColumnIndexOrThrow(_cursor, "Ticket_No");
      final int _cursorIndexOfPassengerName = CursorUtil.getColumnIndexOrThrow(_cursor, "Passenger_Name");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfDestination = CursorUtil.getColumnIndexOrThrow(_cursor, "destination");
      final int _cursorIndexOfClassType = CursorUtil.getColumnIndexOrThrow(_cursor, "classType");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSeat = CursorUtil.getColumnIndexOrThrow(_cursor, "seat");
      final List<Ticket> _result = new ArrayList<Ticket>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ticket _item;
        _item = new Ticket();
        final String _tmpTicket_No;
        if (_cursor.isNull(_cursorIndexOfTicketNo)) {
          _tmpTicket_No = null;
        } else {
          _tmpTicket_No = _cursor.getString(_cursorIndexOfTicketNo);
        }
        _item.setTicket_No(_tmpTicket_No);
        final String _tmpPassenger_Name;
        if (_cursor.isNull(_cursorIndexOfPassengerName)) {
          _tmpPassenger_Name = null;
        } else {
          _tmpPassenger_Name = _cursor.getString(_cursorIndexOfPassengerName);
        }
        _item.setPassenger_Name(_tmpPassenger_Name);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _item.setSource(_tmpSource);
        final String _tmpDestination;
        if (_cursor.isNull(_cursorIndexOfDestination)) {
          _tmpDestination = null;
        } else {
          _tmpDestination = _cursor.getString(_cursorIndexOfDestination);
        }
        _item.setDestination(_tmpDestination);
        final String _tmpClassType;
        if (_cursor.isNull(_cursorIndexOfClassType)) {
          _tmpClassType = null;
        } else {
          _tmpClassType = _cursor.getString(_cursorIndexOfClassType);
        }
        _item.setClassType(_tmpClassType);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        final String _tmpSeat;
        if (_cursor.isNull(_cursorIndexOfSeat)) {
          _tmpSeat = null;
        } else {
          _tmpSeat = _cursor.getString(_cursorIndexOfSeat);
        }
        _item.setSeat(_tmpSeat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Ticket getTicketByTicketNo(final String ticketNo) {
    final String _sql = "SELECT * FROM Ticket WHERE Ticket_No = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (ticketNo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, ticketNo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTicketNo = CursorUtil.getColumnIndexOrThrow(_cursor, "Ticket_No");
      final int _cursorIndexOfPassengerName = CursorUtil.getColumnIndexOrThrow(_cursor, "Passenger_Name");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfDestination = CursorUtil.getColumnIndexOrThrow(_cursor, "destination");
      final int _cursorIndexOfClassType = CursorUtil.getColumnIndexOrThrow(_cursor, "classType");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSeat = CursorUtil.getColumnIndexOrThrow(_cursor, "seat");
      final Ticket _result;
      if(_cursor.moveToFirst()) {
        _result = new Ticket();
        final String _tmpTicket_No;
        if (_cursor.isNull(_cursorIndexOfTicketNo)) {
          _tmpTicket_No = null;
        } else {
          _tmpTicket_No = _cursor.getString(_cursorIndexOfTicketNo);
        }
        _result.setTicket_No(_tmpTicket_No);
        final String _tmpPassenger_Name;
        if (_cursor.isNull(_cursorIndexOfPassengerName)) {
          _tmpPassenger_Name = null;
        } else {
          _tmpPassenger_Name = _cursor.getString(_cursorIndexOfPassengerName);
        }
        _result.setPassenger_Name(_tmpPassenger_Name);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _result.setSource(_tmpSource);
        final String _tmpDestination;
        if (_cursor.isNull(_cursorIndexOfDestination)) {
          _tmpDestination = null;
        } else {
          _tmpDestination = _cursor.getString(_cursorIndexOfDestination);
        }
        _result.setDestination(_tmpDestination);
        final String _tmpClassType;
        if (_cursor.isNull(_cursorIndexOfClassType)) {
          _tmpClassType = null;
        } else {
          _tmpClassType = _cursor.getString(_cursorIndexOfClassType);
        }
        _result.setClassType(_tmpClassType);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _result.setTrain_id(_tmpTrain_id);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _result.setDate(_tmpDate);
        final String _tmpSeat;
        if (_cursor.isNull(_cursorIndexOfSeat)) {
          _tmpSeat = null;
        } else {
          _tmpSeat = _cursor.getString(_cursorIndexOfSeat);
        }
        _result.setSeat(_tmpSeat);
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
  public List<Ticket> getTicketsByPassengerName(final String passengerName) {
    final String _sql = "SELECT * FROM Ticket WHERE Passenger_Name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (passengerName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, passengerName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTicketNo = CursorUtil.getColumnIndexOrThrow(_cursor, "Ticket_No");
      final int _cursorIndexOfPassengerName = CursorUtil.getColumnIndexOrThrow(_cursor, "Passenger_Name");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfDestination = CursorUtil.getColumnIndexOrThrow(_cursor, "destination");
      final int _cursorIndexOfClassType = CursorUtil.getColumnIndexOrThrow(_cursor, "classType");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSeat = CursorUtil.getColumnIndexOrThrow(_cursor, "seat");
      final List<Ticket> _result = new ArrayList<Ticket>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ticket _item;
        _item = new Ticket();
        final String _tmpTicket_No;
        if (_cursor.isNull(_cursorIndexOfTicketNo)) {
          _tmpTicket_No = null;
        } else {
          _tmpTicket_No = _cursor.getString(_cursorIndexOfTicketNo);
        }
        _item.setTicket_No(_tmpTicket_No);
        final String _tmpPassenger_Name;
        if (_cursor.isNull(_cursorIndexOfPassengerName)) {
          _tmpPassenger_Name = null;
        } else {
          _tmpPassenger_Name = _cursor.getString(_cursorIndexOfPassengerName);
        }
        _item.setPassenger_Name(_tmpPassenger_Name);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _item.setSource(_tmpSource);
        final String _tmpDestination;
        if (_cursor.isNull(_cursorIndexOfDestination)) {
          _tmpDestination = null;
        } else {
          _tmpDestination = _cursor.getString(_cursorIndexOfDestination);
        }
        _item.setDestination(_tmpDestination);
        final String _tmpClassType;
        if (_cursor.isNull(_cursorIndexOfClassType)) {
          _tmpClassType = null;
        } else {
          _tmpClassType = _cursor.getString(_cursorIndexOfClassType);
        }
        _item.setClassType(_tmpClassType);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        final String _tmpSeat;
        if (_cursor.isNull(_cursorIndexOfSeat)) {
          _tmpSeat = null;
        } else {
          _tmpSeat = _cursor.getString(_cursorIndexOfSeat);
        }
        _item.setSeat(_tmpSeat);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Ticket getTicketClassById(final int trainId) {
    final String _sql = "SELECT * FROM Ticket WHERE train_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTicketNo = CursorUtil.getColumnIndexOrThrow(_cursor, "Ticket_No");
      final int _cursorIndexOfPassengerName = CursorUtil.getColumnIndexOrThrow(_cursor, "Passenger_Name");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfDestination = CursorUtil.getColumnIndexOrThrow(_cursor, "destination");
      final int _cursorIndexOfClassType = CursorUtil.getColumnIndexOrThrow(_cursor, "classType");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSeat = CursorUtil.getColumnIndexOrThrow(_cursor, "seat");
      final Ticket _result;
      if(_cursor.moveToFirst()) {
        _result = new Ticket();
        final String _tmpTicket_No;
        if (_cursor.isNull(_cursorIndexOfTicketNo)) {
          _tmpTicket_No = null;
        } else {
          _tmpTicket_No = _cursor.getString(_cursorIndexOfTicketNo);
        }
        _result.setTicket_No(_tmpTicket_No);
        final String _tmpPassenger_Name;
        if (_cursor.isNull(_cursorIndexOfPassengerName)) {
          _tmpPassenger_Name = null;
        } else {
          _tmpPassenger_Name = _cursor.getString(_cursorIndexOfPassengerName);
        }
        _result.setPassenger_Name(_tmpPassenger_Name);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _result.setSource(_tmpSource);
        final String _tmpDestination;
        if (_cursor.isNull(_cursorIndexOfDestination)) {
          _tmpDestination = null;
        } else {
          _tmpDestination = _cursor.getString(_cursorIndexOfDestination);
        }
        _result.setDestination(_tmpDestination);
        final String _tmpClassType;
        if (_cursor.isNull(_cursorIndexOfClassType)) {
          _tmpClassType = null;
        } else {
          _tmpClassType = _cursor.getString(_cursorIndexOfClassType);
        }
        _result.setClassType(_tmpClassType);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _result.setTrain_id(_tmpTrain_id);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _result.setDate(_tmpDate);
        final String _tmpSeat;
        if (_cursor.isNull(_cursorIndexOfSeat)) {
          _tmpSeat = null;
        } else {
          _tmpSeat = _cursor.getString(_cursorIndexOfSeat);
        }
        _result.setSeat(_tmpSeat);
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
  public List<Ticket> getTicketClassByTrainAndDay(final String trainId,
      final String passengerName) {
    final String _sql = "SELECT * FROM Ticket WHERE date = ? And Passenger_Name = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (trainId == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, trainId);
    }
    _argIndex = 2;
    if (passengerName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, passengerName);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfTicketNo = CursorUtil.getColumnIndexOrThrow(_cursor, "Ticket_No");
      final int _cursorIndexOfPassengerName = CursorUtil.getColumnIndexOrThrow(_cursor, "Passenger_Name");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final int _cursorIndexOfDestination = CursorUtil.getColumnIndexOrThrow(_cursor, "destination");
      final int _cursorIndexOfClassType = CursorUtil.getColumnIndexOrThrow(_cursor, "classType");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
      final int _cursorIndexOfSeat = CursorUtil.getColumnIndexOrThrow(_cursor, "seat");
      final List<Ticket> _result = new ArrayList<Ticket>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Ticket _item;
        _item = new Ticket();
        final String _tmpTicket_No;
        if (_cursor.isNull(_cursorIndexOfTicketNo)) {
          _tmpTicket_No = null;
        } else {
          _tmpTicket_No = _cursor.getString(_cursorIndexOfTicketNo);
        }
        _item.setTicket_No(_tmpTicket_No);
        final String _tmpPassenger_Name;
        if (_cursor.isNull(_cursorIndexOfPassengerName)) {
          _tmpPassenger_Name = null;
        } else {
          _tmpPassenger_Name = _cursor.getString(_cursorIndexOfPassengerName);
        }
        _item.setPassenger_Name(_tmpPassenger_Name);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _item.setSource(_tmpSource);
        final String _tmpDestination;
        if (_cursor.isNull(_cursorIndexOfDestination)) {
          _tmpDestination = null;
        } else {
          _tmpDestination = _cursor.getString(_cursorIndexOfDestination);
        }
        _item.setDestination(_tmpDestination);
        final String _tmpClassType;
        if (_cursor.isNull(_cursorIndexOfClassType)) {
          _tmpClassType = null;
        } else {
          _tmpClassType = _cursor.getString(_cursorIndexOfClassType);
        }
        _item.setClassType(_tmpClassType);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final String _tmpDate;
        if (_cursor.isNull(_cursorIndexOfDate)) {
          _tmpDate = null;
        } else {
          _tmpDate = _cursor.getString(_cursorIndexOfDate);
        }
        _item.setDate(_tmpDate);
        final String _tmpSeat;
        if (_cursor.isNull(_cursorIndexOfSeat)) {
          _tmpSeat = null;
        } else {
          _tmpSeat = _cursor.getString(_cursorIndexOfSeat);
        }
        _item.setSeat(_tmpSeat);
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
