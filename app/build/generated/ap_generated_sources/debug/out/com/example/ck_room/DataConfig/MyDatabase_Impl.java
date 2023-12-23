package com.example.ck_room.DataConfig;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.example.ck_room.DAO.Date_available_Dao;
import com.example.ck_room.DAO.Date_available_Dao_Impl;
import com.example.ck_room.DAO.FoodDao;
import com.example.ck_room.DAO.FoodDao_Impl;
import com.example.ck_room.DAO.StationDao;
import com.example.ck_room.DAO.StationDao_Impl;
import com.example.ck_room.DAO.TicketDao;
import com.example.ck_room.DAO.TicketDao_Impl;
import com.example.ck_room.DAO.TrainDao;
import com.example.ck_room.DAO.TrainDao_Impl;
import com.example.ck_room.DAO.Train_class_Dao;
import com.example.ck_room.DAO.Train_class_Dao_Impl;
import com.example.ck_room.DAO.UserDao;
import com.example.ck_room.DAO.UserDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class MyDatabase_Impl extends MyDatabase {
  private volatile UserDao _userDao;

  private volatile TrainDao _trainDao;

  private volatile StationDao _stationDao;

  private volatile Train_class_Dao _trainClassDao;

  private volatile TicketDao _ticketDao;

  private volatile Date_available_Dao _dateAvailableDao;

  private volatile FoodDao _foodDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(4) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `user` (`EmailID` TEXT NOT NULL, `firstName` TEXT, `lastName` TEXT, `pass` TEXT, `phone` TEXT, `dob` TEXT, `gender` TEXT, `block` INTEGER NOT NULL, `coin` REAL NOT NULL, PRIMARY KEY(`EmailID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Train` (`train_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `Train_name` TEXT, `Source_stn` TEXT, `Destination_stn` TEXT, `Source_ID` INTEGER NOT NULL, `Destination_ID` INTEGER NOT NULL, `timeStart` TEXT, `timeEnd` TEXT, FOREIGN KEY(`Source_ID`) REFERENCES `station`(`station_id`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`Destination_ID`) REFERENCES `station`(`station_id`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `station` (`station_id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `address` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Train_class` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `train_id` INTEGER NOT NULL, `Economy_Fare` REAL NOT NULL, `Economy_Passenger` INTEGER NOT NULL, `Business_Fare` REAL NOT NULL, `Business_Passenger` INTEGER NOT NULL, `First_Fare` REAL NOT NULL, `First_Passenger` INTEGER NOT NULL, `takenSeats_Economy` TEXT, `takenSeats_Business` TEXT, `takenSeats_First` TEXT, FOREIGN KEY(`train_id`) REFERENCES `Train`(`train_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Ticket` (`Ticket_No` TEXT NOT NULL, `Passenger_Name` TEXT, `source` TEXT, `destination` TEXT, `classType` TEXT, `train_id` INTEGER NOT NULL, `date` TEXT, `seat` TEXT, `price` REAL NOT NULL, `statusPay` TEXT, PRIMARY KEY(`Ticket_No`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `day_available` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `train_id` INTEGER NOT NULL, `day_available` TEXT, FOREIGN KEY(`train_id`) REFERENCES `Train`(`train_id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `Food` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `name` TEXT, `type` TEXT, `price` TEXT, `drawable` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '8cd9f4e5a1813ee509bcb01534ff51fd')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `user`");
        _db.execSQL("DROP TABLE IF EXISTS `Train`");
        _db.execSQL("DROP TABLE IF EXISTS `station`");
        _db.execSQL("DROP TABLE IF EXISTS `Train_class`");
        _db.execSQL("DROP TABLE IF EXISTS `Ticket`");
        _db.execSQL("DROP TABLE IF EXISTS `day_available`");
        _db.execSQL("DROP TABLE IF EXISTS `Food`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsUser = new HashMap<String, TableInfo.Column>(9);
        _columnsUser.put("EmailID", new TableInfo.Column("EmailID", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("firstName", new TableInfo.Column("firstName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("lastName", new TableInfo.Column("lastName", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("pass", new TableInfo.Column("pass", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("phone", new TableInfo.Column("phone", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("dob", new TableInfo.Column("dob", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("gender", new TableInfo.Column("gender", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("block", new TableInfo.Column("block", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUser.put("coin", new TableInfo.Column("coin", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUser = new TableInfo("user", _columnsUser, _foreignKeysUser, _indicesUser);
        final TableInfo _existingUser = TableInfo.read(_db, "user");
        if (! _infoUser.equals(_existingUser)) {
          return new RoomOpenHelper.ValidationResult(false, "user(com.example.ck_room.Entity.User).\n"
                  + " Expected:\n" + _infoUser + "\n"
                  + " Found:\n" + _existingUser);
        }
        final HashMap<String, TableInfo.Column> _columnsTrain = new HashMap<String, TableInfo.Column>(8);
        _columnsTrain.put("train_id", new TableInfo.Column("train_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrain.put("Train_name", new TableInfo.Column("Train_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrain.put("Source_stn", new TableInfo.Column("Source_stn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrain.put("Destination_stn", new TableInfo.Column("Destination_stn", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrain.put("Source_ID", new TableInfo.Column("Source_ID", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrain.put("Destination_ID", new TableInfo.Column("Destination_ID", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrain.put("timeStart", new TableInfo.Column("timeStart", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrain.put("timeEnd", new TableInfo.Column("timeEnd", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrain = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysTrain.add(new TableInfo.ForeignKey("station", "NO ACTION", "NO ACTION",Arrays.asList("Source_ID"), Arrays.asList("station_id")));
        _foreignKeysTrain.add(new TableInfo.ForeignKey("station", "NO ACTION", "NO ACTION",Arrays.asList("Destination_ID"), Arrays.asList("station_id")));
        final HashSet<TableInfo.Index> _indicesTrain = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrain = new TableInfo("Train", _columnsTrain, _foreignKeysTrain, _indicesTrain);
        final TableInfo _existingTrain = TableInfo.read(_db, "Train");
        if (! _infoTrain.equals(_existingTrain)) {
          return new RoomOpenHelper.ValidationResult(false, "Train(com.example.ck_room.Entity.Train).\n"
                  + " Expected:\n" + _infoTrain + "\n"
                  + " Found:\n" + _existingTrain);
        }
        final HashMap<String, TableInfo.Column> _columnsStation = new HashMap<String, TableInfo.Column>(3);
        _columnsStation.put("station_id", new TableInfo.Column("station_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStation.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsStation.put("address", new TableInfo.Column("address", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysStation = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesStation = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoStation = new TableInfo("station", _columnsStation, _foreignKeysStation, _indicesStation);
        final TableInfo _existingStation = TableInfo.read(_db, "station");
        if (! _infoStation.equals(_existingStation)) {
          return new RoomOpenHelper.ValidationResult(false, "station(com.example.ck_room.Entity.Station).\n"
                  + " Expected:\n" + _infoStation + "\n"
                  + " Found:\n" + _existingStation);
        }
        final HashMap<String, TableInfo.Column> _columnsTrainClass = new HashMap<String, TableInfo.Column>(11);
        _columnsTrainClass.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("train_id", new TableInfo.Column("train_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("Economy_Fare", new TableInfo.Column("Economy_Fare", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("Economy_Passenger", new TableInfo.Column("Economy_Passenger", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("Business_Fare", new TableInfo.Column("Business_Fare", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("Business_Passenger", new TableInfo.Column("Business_Passenger", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("First_Fare", new TableInfo.Column("First_Fare", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("First_Passenger", new TableInfo.Column("First_Passenger", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("takenSeats_Economy", new TableInfo.Column("takenSeats_Economy", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("takenSeats_Business", new TableInfo.Column("takenSeats_Business", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTrainClass.put("takenSeats_First", new TableInfo.Column("takenSeats_First", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTrainClass = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTrainClass.add(new TableInfo.ForeignKey("Train", "CASCADE", "NO ACTION",Arrays.asList("train_id"), Arrays.asList("train_id")));
        final HashSet<TableInfo.Index> _indicesTrainClass = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTrainClass = new TableInfo("Train_class", _columnsTrainClass, _foreignKeysTrainClass, _indicesTrainClass);
        final TableInfo _existingTrainClass = TableInfo.read(_db, "Train_class");
        if (! _infoTrainClass.equals(_existingTrainClass)) {
          return new RoomOpenHelper.ValidationResult(false, "Train_class(com.example.ck_room.Entity.Train_class).\n"
                  + " Expected:\n" + _infoTrainClass + "\n"
                  + " Found:\n" + _existingTrainClass);
        }
        final HashMap<String, TableInfo.Column> _columnsTicket = new HashMap<String, TableInfo.Column>(10);
        _columnsTicket.put("Ticket_No", new TableInfo.Column("Ticket_No", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("Passenger_Name", new TableInfo.Column("Passenger_Name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("source", new TableInfo.Column("source", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("destination", new TableInfo.Column("destination", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("classType", new TableInfo.Column("classType", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("train_id", new TableInfo.Column("train_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("date", new TableInfo.Column("date", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("seat", new TableInfo.Column("seat", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("price", new TableInfo.Column("price", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTicket.put("statusPay", new TableInfo.Column("statusPay", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTicket = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTicket = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTicket = new TableInfo("Ticket", _columnsTicket, _foreignKeysTicket, _indicesTicket);
        final TableInfo _existingTicket = TableInfo.read(_db, "Ticket");
        if (! _infoTicket.equals(_existingTicket)) {
          return new RoomOpenHelper.ValidationResult(false, "Ticket(com.example.ck_room.Entity.Ticket).\n"
                  + " Expected:\n" + _infoTicket + "\n"
                  + " Found:\n" + _existingTicket);
        }
        final HashMap<String, TableInfo.Column> _columnsDayAvailable = new HashMap<String, TableInfo.Column>(3);
        _columnsDayAvailable.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDayAvailable.put("train_id", new TableInfo.Column("train_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDayAvailable.put("day_available", new TableInfo.Column("day_available", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDayAvailable = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysDayAvailable.add(new TableInfo.ForeignKey("Train", "CASCADE", "NO ACTION",Arrays.asList("train_id"), Arrays.asList("train_id")));
        final HashSet<TableInfo.Index> _indicesDayAvailable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDayAvailable = new TableInfo("day_available", _columnsDayAvailable, _foreignKeysDayAvailable, _indicesDayAvailable);
        final TableInfo _existingDayAvailable = TableInfo.read(_db, "day_available");
        if (! _infoDayAvailable.equals(_existingDayAvailable)) {
          return new RoomOpenHelper.ValidationResult(false, "day_available(com.example.ck_room.Entity.Day_available).\n"
                  + " Expected:\n" + _infoDayAvailable + "\n"
                  + " Found:\n" + _existingDayAvailable);
        }
        final HashMap<String, TableInfo.Column> _columnsFood = new HashMap<String, TableInfo.Column>(5);
        _columnsFood.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("name", new TableInfo.Column("name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("type", new TableInfo.Column("type", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("price", new TableInfo.Column("price", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsFood.put("drawable", new TableInfo.Column("drawable", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysFood = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesFood = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoFood = new TableInfo("Food", _columnsFood, _foreignKeysFood, _indicesFood);
        final TableInfo _existingFood = TableInfo.read(_db, "Food");
        if (! _infoFood.equals(_existingFood)) {
          return new RoomOpenHelper.ValidationResult(false, "Food(com.example.ck_room.Entity.Food).\n"
                  + " Expected:\n" + _infoFood + "\n"
                  + " Found:\n" + _existingFood);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "8cd9f4e5a1813ee509bcb01534ff51fd", "b457c575630f624617969fa048bb8232");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "user","Train","station","Train_class","Ticket","day_available","Food");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `user`");
      _db.execSQL("DELETE FROM `Train`");
      _db.execSQL("DELETE FROM `station`");
      _db.execSQL("DELETE FROM `Train_class`");
      _db.execSQL("DELETE FROM `Ticket`");
      _db.execSQL("DELETE FROM `day_available`");
      _db.execSQL("DELETE FROM `Food`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UserDao.class, UserDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TrainDao.class, TrainDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(StationDao.class, StationDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(Train_class_Dao.class, Train_class_Dao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TicketDao.class, TicketDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(Date_available_Dao.class, Date_available_Dao_Impl.getRequiredConverters());
    _typeConvertersMap.put(FoodDao.class, FoodDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public UserDao userDao() {
    if (_userDao != null) {
      return _userDao;
    } else {
      synchronized(this) {
        if(_userDao == null) {
          _userDao = new UserDao_Impl(this);
        }
        return _userDao;
      }
    }
  }

  @Override
  public TrainDao trainDao() {
    if (_trainDao != null) {
      return _trainDao;
    } else {
      synchronized(this) {
        if(_trainDao == null) {
          _trainDao = new TrainDao_Impl(this);
        }
        return _trainDao;
      }
    }
  }

  @Override
  public StationDao stationDao() {
    if (_stationDao != null) {
      return _stationDao;
    } else {
      synchronized(this) {
        if(_stationDao == null) {
          _stationDao = new StationDao_Impl(this);
        }
        return _stationDao;
      }
    }
  }

  @Override
  public Train_class_Dao trainClassDao() {
    if (_trainClassDao != null) {
      return _trainClassDao;
    } else {
      synchronized(this) {
        if(_trainClassDao == null) {
          _trainClassDao = new Train_class_Dao_Impl(this);
        }
        return _trainClassDao;
      }
    }
  }

  @Override
  public TicketDao ticketDao() {
    if (_ticketDao != null) {
      return _ticketDao;
    } else {
      synchronized(this) {
        if(_ticketDao == null) {
          _ticketDao = new TicketDao_Impl(this);
        }
        return _ticketDao;
      }
    }
  }

  @Override
  public Date_available_Dao dateAvailableDao() {
    if (_dateAvailableDao != null) {
      return _dateAvailableDao;
    } else {
      synchronized(this) {
        if(_dateAvailableDao == null) {
          _dateAvailableDao = new Date_available_Dao_Impl(this);
        }
        return _dateAvailableDao;
      }
    }
  }

  @Override
  public FoodDao foodDao() {
    if (_foodDao != null) {
      return _foodDao;
    } else {
      synchronized(this) {
        if(_foodDao == null) {
          _foodDao = new FoodDao_Impl(this);
        }
        return _foodDao;
      }
    }
  }
}
