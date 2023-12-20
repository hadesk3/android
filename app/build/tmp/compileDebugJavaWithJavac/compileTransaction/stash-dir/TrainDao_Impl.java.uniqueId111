package com.example.ck_room.DAO;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ck_room.Entity.Train;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class TrainDao_Impl implements TrainDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Train> __insertionAdapterOfTrain;

  private final EntityDeletionOrUpdateAdapter<Train> __deletionAdapterOfTrain;

  private final EntityDeletionOrUpdateAdapter<Train> __updateAdapterOfTrain;

  public TrainDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTrain = new EntityInsertionAdapter<Train>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `Train` (`train_id`,`Train_name`,`Source_stn`,`Destination_stn`,`Source_ID`,`Destination_ID`,`timeStart`,`timeEnd`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train value) {
        stmt.bindLong(1, value.getTrain_id());
        if (value.getTrain_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTrain_name());
        }
        if (value.getSource_stn() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSource_stn());
        }
        if (value.getDestination_stn() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDestination_stn());
        }
        stmt.bindLong(5, value.getSource_ID());
        stmt.bindLong(6, value.getDestination_ID());
        if (value.getTimeStart() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStart());
        }
        if (value.getTimeEnd() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimeEnd());
        }
      }
    };
    this.__deletionAdapterOfTrain = new EntityDeletionOrUpdateAdapter<Train>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `Train` WHERE `train_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train value) {
        stmt.bindLong(1, value.getTrain_id());
      }
    };
    this.__updateAdapterOfTrain = new EntityDeletionOrUpdateAdapter<Train>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `Train` SET `train_id` = ?,`Train_name` = ?,`Source_stn` = ?,`Destination_stn` = ?,`Source_ID` = ?,`Destination_ID` = ?,`timeStart` = ?,`timeEnd` = ? WHERE `train_id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Train value) {
        stmt.bindLong(1, value.getTrain_id());
        if (value.getTrain_name() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTrain_name());
        }
        if (value.getSource_stn() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSource_stn());
        }
        if (value.getDestination_stn() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDestination_stn());
        }
        stmt.bindLong(5, value.getSource_ID());
        stmt.bindLong(6, value.getDestination_ID());
        if (value.getTimeStart() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getTimeStart());
        }
        if (value.getTimeEnd() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getTimeEnd());
        }
        stmt.bindLong(9, value.getTrain_id());
      }
    };
  }

  @Override
  public long insert(final Train train) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfTrain.insertAndReturnId(train);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Train train) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTrain.handle(train);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Train train) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTrain.handle(train);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Train> getAllTrains() {
    final String _sql = "SELECT * FROM train";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
      final List<Train> _result = new ArrayList<Train>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Train _item;
        _item = new Train();
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final String _tmpTrain_name;
        if (_cursor.isNull(_cursorIndexOfTrainName)) {
          _tmpTrain_name = null;
        } else {
          _tmpTrain_name = _cursor.getString(_cursorIndexOfTrainName);
        }
        _item.setTrain_name(_tmpTrain_name);
        final String _tmpSource_stn;
        if (_cursor.isNull(_cursorIndexOfSourceStn)) {
          _tmpSource_stn = null;
        } else {
          _tmpSource_stn = _cursor.getString(_cursorIndexOfSourceStn);
        }
        _item.setSource_stn(_tmpSource_stn);
        final String _tmpDestination_stn;
        if (_cursor.isNull(_cursorIndexOfDestinationStn)) {
          _tmpDestination_stn = null;
        } else {
          _tmpDestination_stn = _cursor.getString(_cursorIndexOfDestinationStn);
        }
        _item.setDestination_stn(_tmpDestination_stn);
        final int _tmpSource_ID;
        _tmpSource_ID = _cursor.getInt(_cursorIndexOfSourceID);
        _item.setSource_ID(_tmpSource_ID);
        final int _tmpDestination_ID;
        _tmpDestination_ID = _cursor.getInt(_cursorIndexOfDestinationID);
        _item.setDestination_ID(_tmpDestination_ID);
        final String _tmpTimeStart;
        if (_cursor.isNull(_cursorIndexOfTimeStart)) {
          _tmpTimeStart = null;
        } else {
          _tmpTimeStart = _cursor.getString(_cursorIndexOfTimeStart);
        }
        _item.setTimeStart(_tmpTimeStart);
        final String _tmpTimeEnd;
        if (_cursor.isNull(_cursorIndexOfTimeEnd)) {
          _tmpTimeEnd = null;
        } else {
          _tmpTimeEnd = _cursor.getString(_cursorIndexOfTimeEnd);
        }
        _item.setTimeEnd(_tmpTimeEnd);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Train> findTrainsByStationsAndDay(final String sourceStn, final String destinationStn,
      final String dayAvailable) {
    final String _sql = "SELECT * FROM Train JOIN Day_available ON Train.train_id = Day_available.train_id WHERE Train.Source_stn = ? AND Train.Destination_stn = ? AND Day_available.day_available = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (sourceStn == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, sourceStn);
    }
    _argIndex = 2;
    if (destinationStn == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, destinationStn);
    }
    _argIndex = 3;
    if (dayAvailable == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, dayAvailable);
    }
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
      final int _cursorIndexOfTrainId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "train_id");
      final List<Train> _result = new ArrayList<Train>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Train _item;
        _item = new Train();
        final int _tmpTrain_id;
        _tmpTrain_id = _cursor.getInt(_cursorIndexOfTrainId);
        _item.setTrain_id(_tmpTrain_id);
        final String _tmpTrain_name;
        if (_cursor.isNull(_cursorIndexOfTrainName)) {
          _tmpTrain_name = null;
        } else {
          _tmpTrain_name = _cursor.getString(_cursorIndexOfTrainName);
        }
        _item.setTrain_name(_tmpTrain_name);
        final String _tmpSource_stn;
        if (_cursor.isNull(_cursorIndexOfSourceStn)) {
          _tmpSource_stn = null;
        } else {
          _tmpSource_stn = _cursor.getString(_cursorIndexOfSourceStn);
        }
        _item.setSource_stn(_tmpSource_stn);
        final String _tmpDestination_stn;
        if (_cursor.isNull(_cursorIndexOfDestinationStn)) {
          _tmpDestination_stn = null;
        } else {
          _tmpDestination_stn = _cursor.getString(_cursorIndexOfDestinationStn);
        }
        _item.setDestination_stn(_tmpDestination_stn);
        final int _tmpSource_ID;
        _tmpSource_ID = _cursor.getInt(_cursorIndexOfSourceID);
        _item.setSource_ID(_tmpSource_ID);
        final int _tmpDestination_ID;
        _tmpDestination_ID = _cursor.getInt(_cursorIndexOfDestinationID);
        _item.setDestination_ID(_tmpDestination_ID);
        final String _tmpTimeStart;
        if (_cursor.isNull(_cursorIndexOfTimeStart)) {
          _tmpTimeStart = null;
        } else {
          _tmpTimeStart = _cursor.getString(_cursorIndexOfTimeStart);
        }
        _item.setTimeStart(_tmpTimeStart);
        final String _tmpTimeEnd;
        if (_cursor.isNull(_cursorIndexOfTimeEnd)) {
          _tmpTimeEnd = null;
        } else {
          _tmpTimeEnd = _cursor.getString(_cursorIndexOfTimeEnd);
        }
        _item.setTimeEnd(_tmpTimeEnd);
        final int _tmpTrain_id_1;
        _tmpTrain_id_1 = _cursor.getInt(_cursorIndexOfTrainId_1);
        _item.setTrain_id(_tmpTrain_id_1);
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
