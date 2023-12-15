package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Route_has_station;
import com.example.ck_room.Entity.Train;
import java.lang.Class;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class Route_has_station_Dao_Impl implements Route_has_station_Dao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Route_has_station> __insertionAdapterOfRoute_has_station;

  private final EntityDeletionOrUpdateAdapter<Route_has_station> __deletionAdapterOfRoute_has_station;

  private final EntityDeletionOrUpdateAdapter<Route_has_station> __updateAdapterOfRoute_has_station;

  public Route_has_station_Dao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRoute_has_station = new EntityInsertionAdapter<Route_has_station>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `route_has_station` (`id`,`train_id`,`station_id`,`stop_number`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Route_has_station value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        stmt.bindLong(3, value.getStation_id());
        if (value.getStop_number() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStop_number());
        }
      }
    };
    this.__deletionAdapterOfRoute_has_station = new EntityDeletionOrUpdateAdapter<Route_has_station>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `route_has_station` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Route_has_station value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfRoute_has_station = new EntityDeletionOrUpdateAdapter<Route_has_station>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `route_has_station` SET `id` = ?,`train_id` = ?,`station_id` = ?,`stop_number` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Route_has_station value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getTrain_id());
        stmt.bindLong(3, value.getStation_id());
        if (value.getStop_number() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getStop_number());
        }
        stmt.bindLong(5, value.getId());
      }
    };
  }

  @Override
  public void insert(final Route_has_station routeHasStation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfRoute_has_station.insert(routeHasStation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Route_has_station routeHasStation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfRoute_has_station.handle(routeHasStation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Route_has_station routeHasStation) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfRoute_has_station.handle(routeHasStation);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Route_has_station> getAllRouteHasStations() {
    final String _sql = "SELECT * FROM route_has_station";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStationId = CursorUtil.getColumnIndexOrThrow(_cursor, "station_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final List<Route_has_station> _result = new ArrayList<Route_has_station>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Route_has_station _item;
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final int _tmpStation_id;
        _tmpStation_id = _cursor.getInt(_cursorIndexOfStationId);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _item = new Route_has_station(_tmpTrain_id,_tmpStation_id,_tmpStop_number);
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
  public List<Route_has_station> getRouteHasStationsByTrainId(final int trainId) {
    final String _sql = "SELECT * FROM route_has_station WHERE train_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStationId = CursorUtil.getColumnIndexOrThrow(_cursor, "station_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final List<Route_has_station> _result = new ArrayList<Route_has_station>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Route_has_station _item;
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final int _tmpStation_id;
        _tmpStation_id = _cursor.getInt(_cursorIndexOfStationId);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _item = new Route_has_station(_tmpTrain_id,_tmpStation_id,_tmpStop_number);
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
  public List<Route_has_station> getRouteHasStationsByStationId(final int stationId) {
    final String _sql = "SELECT * FROM route_has_station WHERE station_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, stationId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStationId = CursorUtil.getColumnIndexOrThrow(_cursor, "station_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final List<Route_has_station> _result = new ArrayList<Route_has_station>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Route_has_station _item;
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final int _tmpStation_id;
        _tmpStation_id = _cursor.getInt(_cursorIndexOfStationId);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _item = new Route_has_station(_tmpTrain_id,_tmpStation_id,_tmpStop_number);
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
  public Route_has_station getRouteHasStation(final int trainId, final int stationId) {
    final String _sql = "SELECT * FROM route_has_station WHERE train_id = ? AND station_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, trainId);
    _argIndex = 2;
    _statement.bindLong(_argIndex, stationId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStationId = CursorUtil.getColumnIndexOrThrow(_cursor, "station_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final Route_has_station _result;
      if(_cursor.moveToFirst()) {
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final int _tmpStation_id;
        _tmpStation_id = _cursor.getInt(_cursorIndexOfStationId);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _result = new Route_has_station(_tmpTrain_id,_tmpStation_id,_tmpStop_number);
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

  @Override
  public List<Route_has_station> getRouteHasStationsByStationIds(final List<Integer> stationIds) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT * FROM route_has_station WHERE station_id IN (");
    final int _inputSize = stationIds.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (Integer _item : stationIds) {
      if (_item == null) {
        _statement.bindNull(_argIndex);
      } else {
        _statement.bindLong(_argIndex, _item);
      }
      _argIndex ++;
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfTrainId = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final int _cursorIndexOfStationId = CursorUtil.getColumnIndexOrThrow(_cursor, "station_id");
      final int _cursorIndexOfStopNumber = CursorUtil.getColumnIndexOrThrow(_cursor, "stop_number");
      final List<Route_has_station> _result = new ArrayList<Route_has_station>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Route_has_station _item_1;
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        final int _tmpStation_id;
        _tmpStation_id = _cursor.getInt(_cursorIndexOfStationId);
        final String _tmpStop_number;
        if (_cursor.isNull(_cursorIndexOfStopNumber)) {
          _tmpStop_number = null;
        } else {
          _tmpStop_number = _cursor.getString(_cursorIndexOfStopNumber);
        }
        _item_1 = new Route_has_station(_tmpTrain_id,_tmpStation_id,_tmpStop_number);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item_1.setId(_tmpId);
        _result.add(_item_1);
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
