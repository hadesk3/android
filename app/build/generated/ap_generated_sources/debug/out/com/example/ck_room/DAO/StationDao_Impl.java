package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Station;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class StationDao_Impl implements StationDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Station> __insertionAdapterOfStation;

  private final EntityDeletionOrUpdateAdapter<Station> __deletionAdapterOfStation;

  private final EntityDeletionOrUpdateAdapter<Station> __updateAdapterOfStation;

  public StationDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStation = new EntityInsertionAdapter<Station>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `station` (`station_id`,`name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Station value) {
        stmt.bindLong(1, value.getStationId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
      }
    };
    this.__deletionAdapterOfStation = new EntityDeletionOrUpdateAdapter<Station>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `station` WHERE `station_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Station value) {
        stmt.bindLong(1, value.getStationId());
      }
    };
    this.__updateAdapterOfStation = new EntityDeletionOrUpdateAdapter<Station>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `station` SET `station_id` = ?,`name` = ? WHERE `station_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Station value) {
        stmt.bindLong(1, value.getStationId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        stmt.bindLong(3, value.getStationId());
      }
    };
  }

  @Override
  public void insert(final Station station) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStation.insert(station);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Station station) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfStation.handle(station);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Station station) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfStation.handle(station);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Station> getAllStations() {
    final String _sql = "SELECT * FROM station";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStationId = CursorUtil.getColumnIndexOrThrow(_cursor, "station_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<Station> _result = new ArrayList<Station>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Station _item;
        _item = new Station();
        final int _tmpStationId;
        _tmpStationId = _cursor.getInt(_cursorIndexOfStationId);
        _item.setStationId(_tmpStationId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _item.setName(_tmpName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Station getStationById(final int id) {
    final String _sql = "SELECT * FROM station where station_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfStationId = CursorUtil.getColumnIndexOrThrow(_cursor, "station_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final Station _result;
      if(_cursor.moveToFirst()) {
        _result = new Station();
        final int _tmpStationId;
        _tmpStationId = _cursor.getInt(_cursorIndexOfStationId);
        _result.setStationId(_tmpStationId);
        final String _tmpName;
        if (_cursor.isNull(_cursorIndexOfName)) {
          _tmpName = null;
        } else {
          _tmpName = _cursor.getString(_cursorIndexOfName);
        }
        _result.setName(_tmpName);
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
