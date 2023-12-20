package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Route;
import com.example.ck_room.Entity.Train;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RouteDao_Impl implements RouteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Route> __insertionAdapterOfRoute;

  private final EntityDeletionOrUpdateAdapter<Route> __deletionAdapterOfRoute;

  private final EntityDeletionOrUpdateAdapter<Route> __updateAdapterOfRoute;

  public RouteDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRoute = new EntityInsertionAdapter<Route>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `route` (`id`,`train_id`,`stop_number`,`station`,`arrival_time`,`departure_time`,`source`) VALUES (nullif(?, 0),?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Route value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        if (value.getStop_number() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStop_number());
        }
        if (value.getStation() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStation());
        }
        if (value.getArrival_time() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getArrival_time());
        }
        if (value.getDeparture_time() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDeparture_time());
        }
        if (value.getSource() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSource());
        }
      }
    };
    this.__deletionAdapterOfRoute = new EntityDeletionOrUpdateAdapter<Route>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `route` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Route value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfRoute = new EntityDeletionOrUpdateAdapter<Route>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `route` SET `id` = ?,`train_id` = ?,`stop_number` = ?,`station` = ?,`arrival_time` = ?,`departure_time` = ?,`source` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Route value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        if (value.getStop_number() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getStop_number());
        }
        if (value.getStation() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStation());
        }
        if (value.getArrival_time() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getArrival_time());
        }
        if (value.getDeparture_time() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDeparture_time());
        }
        if (value.getSource() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSource());
        }
        stmt.bindLong(8, value.getId());
      }
    };
  }

  @Override
  public void insert(final Route route) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRoute.insert(route);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Route route) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoute.handle(route);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Route route) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRoute.handle(route);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Route> getAllRoutes() {
    final String _sql = "SELECT * FROM route";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final int _cursorIndexOfStation = CursorUtil.getColumnIndexOrThrow(_cursor, "station");
      final int _cursorIndexOfArrivalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "arrival_time");
      final int _cursorIndexOfDepartureTime = CursorUtil.getColumnIndexOrThrow(_cursor, "departure_time");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final List<Route> _result = new ArrayList<Route>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Route _item;
        _item = new Route();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _item.setStop_number(_tmpStop_number);
        final String _tmpStation;
        if (_cursor.isNull(_cursorIndexOfStation)) {
          _tmpStation = null;
        } else {
          _tmpStation = _cursor.getString(_cursorIndexOfStation);
        }
        _item.setStation(_tmpStation);
        final String _tmpArrival_time;
        if (_cursor.isNull(_cursorIndexOfArrivalTime)) {
          _tmpArrival_time = null;
        } else {
          _tmpArrival_time = _cursor.getString(_cursorIndexOfArrivalTime);
        }
        _item.setArrival_time(_tmpArrival_time);
        final String _tmpDeparture_time;
        if (_cursor.isNull(_cursorIndexOfDepartureTime)) {
          _tmpDeparture_time = null;
        } else {
          _tmpDeparture_time = _cursor.getString(_cursorIndexOfDepartureTime);
        }
        _item.setDeparture_time(_tmpDeparture_time);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _item.setSource(_tmpSource);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Route> getRoutesByTrainId(final int trainId) {
    final String _sql = "SELECT * FROM route WHERE train_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final int _cursorIndexOfStation = CursorUtil.getColumnIndexOrThrow(_cursor, "station");
      final int _cursorIndexOfArrivalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "arrival_time");
      final int _cursorIndexOfDepartureTime = CursorUtil.getColumnIndexOrThrow(_cursor, "departure_time");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final List<Route> _result = new ArrayList<Route>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Route _item;
        _item = new Route();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _item.setStop_number(_tmpStop_number);
        final String _tmpStation;
        if (_cursor.isNull(_cursorIndexOfStation)) {
          _tmpStation = null;
        } else {
          _tmpStation = _cursor.getString(_cursorIndexOfStation);
        }
        _item.setStation(_tmpStation);
        final String _tmpArrival_time;
        if (_cursor.isNull(_cursorIndexOfArrivalTime)) {
          _tmpArrival_time = null;
        } else {
          _tmpArrival_time = _cursor.getString(_cursorIndexOfArrivalTime);
        }
        _item.setArrival_time(_tmpArrival_time);
        final String _tmpDeparture_time;
        if (_cursor.isNull(_cursorIndexOfDepartureTime)) {
          _tmpDeparture_time = null;
        } else {
          _tmpDeparture_time = _cursor.getString(_cursorIndexOfDepartureTime);
        }
        _item.setDeparture_time(_tmpDeparture_time);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _item.setSource(_tmpSource);
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

  @Override
  public Route getRouteById(final int id) {
    final String _sql = "SELECT * FROM route WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final int _cursorIndexOfStation = CursorUtil.getColumnIndexOrThrow(_cursor, "station");
      final int _cursorIndexOfArrivalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "arrival_time");
      final int _cursorIndexOfDepartureTime = CursorUtil.getColumnIndexOrThrow(_cursor, "departure_time");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final Route _result;
      if(_cursor.moveToFirst()) {
        _result = new Route();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _result.setTrain_id(_tmpTrain_id);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _result.setStop_number(_tmpStop_number);
        final String _tmpStation;
        if (_cursor.isNull(_cursorIndexOfStation)) {
          _tmpStation = null;
        } else {
          _tmpStation = _cursor.getString(_cursorIndexOfStation);
        }
        _result.setStation(_tmpStation);
        final String _tmpArrival_time;
        if (_cursor.isNull(_cursorIndexOfArrivalTime)) {
          _tmpArrival_time = null;
        } else {
          _tmpArrival_time = _cursor.getString(_cursorIndexOfArrivalTime);
        }
        _result.setArrival_time(_tmpArrival_time);
        final String _tmpDeparture_time;
        if (_cursor.isNull(_cursorIndexOfDepartureTime)) {
          _tmpDeparture_time = null;
        } else {
          _tmpDeparture_time = _cursor.getString(_cursorIndexOfDepartureTime);
        }
        _result.setDeparture_time(_tmpDeparture_time);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _result.setSource(_tmpSource);
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
  public List<Route> getRoutesBySource(final String source) {
    final String _sql = "SELECT * FROM route WHERE source = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (source == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, source);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final int _cursorIndexOfStation = CursorUtil.getColumnIndexOrThrow(_cursor, "station");
      final int _cursorIndexOfArrivalTime = CursorUtil.getColumnIndexOrThrow(_cursor, "arrival_time");
      final int _cursorIndexOfDepartureTime = CursorUtil.getColumnIndexOrThrow(_cursor, "departure_time");
      final int _cursorIndexOfSource = CursorUtil.getColumnIndexOrThrow(_cursor, "source");
      final List<Route> _result = new ArrayList<Route>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Route _item;
        _item = new Route();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _item.setStop_number(_tmpStop_number);
        final String _tmpStation;
        if (_cursor.isNull(_cursorIndexOfStation)) {
          _tmpStation = null;
        } else {
          _tmpStation = _cursor.getString(_cursorIndexOfStation);
        }
        _item.setStation(_tmpStation);
        final String _tmpArrival_time;
        if (_cursor.isNull(_cursorIndexOfArrivalTime)) {
          _tmpArrival_time = null;
        } else {
          _tmpArrival_time = _cursor.getString(_cursorIndexOfArrivalTime);
        }
        _item.setArrival_time(_tmpArrival_time);
        final String _tmpDeparture_time;
        if (_cursor.isNull(_cursorIndexOfDepartureTime)) {
          _tmpDeparture_time = null;
        } else {
          _tmpDeparture_time = _cursor.getString(_cursorIndexOfDepartureTime);
        }
        _item.setDeparture_time(_tmpDeparture_time);
        final String _tmpSource;
        if (_cursor.isNull(_cursorIndexOfSource)) {
          _tmpSource = null;
        } else {
          _tmpSource = _cursor.getString(_cursorIndexOfSource);
        }
        _item.setSource(_tmpSource);
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
