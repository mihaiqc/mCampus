package com.concordia.mcga.helperClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;


//Part of the code was taken from https://blog.reigndesign.com/blog/using-your-own-sqlite-database-in-android-applications/
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "development.db";
    private static SQLiteDatabase db;

    //The Android's default system path of our application database.
    private static String databasePath;
    private static Context context;
    private static DatabaseHelper databaseHelper;

    /**
     * Create a DatabaseHelper Object
     * @param context Interface to global information about an application environment.
     */
    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        DatabaseHelper.context = context;
    }

    /**
     * Initializes values for database creation
     * @param context Interface to global information about an application environment.
     */
    public static void setupDatabase(Context context) {
        if (db == null) {
            DatabaseHelper.context = context;
            databasePath = context.getFilesDir().getPath() + "/../databases/";
        }
    }

    /**
     * @return A DatabaseHelper object
     */
    public static DatabaseHelper getInstance() {
        if (context == null) {
            return null;
        }
        if (db == null) {
            return databaseHelper = new DatabaseHelper(context);
        } else {
            return databaseHelper;
        }

    }

    /**
     *
     * @return The database
     */
    public static SQLiteDatabase getDb() {
        return db;
    }

    /**
     * Creates a empty database on the system and rewrites it with our own database.
     */
    public void createDatabase() throws IOException {
        boolean dbExist = isDBExists();

        if (!dbExist) {
            //By calling this method and empty database will be created into the default system path
            //of your application so we are gonna be able to overwrite that database with our database.
            this.getReadableDatabase();

            try {
                copyDatabase();
            } catch (IOException e) {
                Log.e("Database", "error copying");
            }
        }
    }

    /**
     * Check if the database already exist to avoid re-copying the file each time you open the application.
     * @return true if it exists, false if it doesn't
     */
    private boolean isDBExists() {
        SQLiteDatabase checkDB = null;

        try {
            String myPath = databasePath + DATABASE_NAME;
            checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
            Log.e("Database", "not found");
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null;
    }

    /**
     * Copies the database from the local assets-folder to the just created empty database in the
     * system folder, from where it can be accessed and handled.
     * This is done by transfering bytestream.
     */
    private void copyDatabase() throws IOException {

        //Open your local db as the input stream
        InputStream myInput = context.getAssets().open(DATABASE_NAME);

        // Path to the just created empty db
        String outFileName = databasePath + DATABASE_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.close();
        myInput.close();
    }

    /**
     * Open database connection
     * @throws SQLException if the database cannot be opened
     */
    public void openDatabase() throws SQLException {
        //Open the database
        String myPath = databasePath + DATABASE_NAME;
        db = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    /**
     * Closes the database
     */
    @Override
    public synchronized void close() {
        if (db != null) {
            db.close();
        }
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }

}
