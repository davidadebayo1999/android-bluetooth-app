package app.kbuild.com.androidbluetoothapp;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

      BluetoothManager bluetoothManager;
    private final static int REQUEST_ENABLE_BT=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getPackageManager().hasSystemFeature(PackageManager.FEATURE_BLUETOOTH_LE)){
           bluetoothManager=(BluetoothManager)getSystemService(Context.BLUETOOTH_SERVICE);
            BluetoothAdapter bluetoothAdapte=bluetoothManager.getAdapter();

            boolean bleutoothEnabled= bluetoothAdapte.isEnabled();

            if(bleutoothEnabled){
                Toast.makeText(getApplicationContext(),"Bluetooth was enabled",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Enabling your Bluetooth",Toast.LENGTH_SHORT).show();
                Intent enableBlueToothIntent=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBlueToothIntent,REQUEST_ENABLE_BT);
            }
        }
    }
}
