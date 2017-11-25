package com.gzleidi;

import android.util.Log;

import org.java_websocket.WebSocketImpl;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;

public class Wawa {
    private WebSocketClient cc;

    public Wawa( ) {
        WebSocketImpl.DEBUG = true;
    }

    public void connect() {
        try {
            // cc = new ChatClient(new URI(uriField.getText()), area, ( Draft ) draft.getSelectedItem() );
            cc = new WebSocketClient( new URI( "ws://api.wawa.gzleidi.cn" ) ) {
                @Override
                public void onMessage( String message ) {

                    // ta.append( "got: " + message + "\n" );
                }

                @Override
                public void onOpen( ServerHandshake handshake ) {
                    Log.d( "wawa", "connected" );
                    Log.i("wawa","connected");
                }

                @Override
                public void onClose( int code, String reason, boolean remote ) {
                    // ta.append( "You have been disconnected from: " + getURI() + "; Code: " + code + " " + reason + "\n" );
                }

                @Override
                public void onError( Exception ex ) {
                    // ta.append( "Exception occured ...\n" + ex + "\n" );
                    ex.printStackTrace();
                }
            };
            cc.connect();
        } catch ( URISyntaxException ex ) {
            // ta.append( uriField.getText() + " is not a valid WebSocket URI\n" );
        }
    }

    public void start() {
        Log.i("wawa","start");
        JSONObject jsonObject;
        JSONObject jsonObject1;
        try {
            jsonObject = new JSONObject("{uri:'/rooms/1/start',id:12,type:'post',data:{}}");
            String uri = jsonObject.getString("uri");
            int id = jsonObject.getInt("id");
            Log.i("wawa","start");
            Log.i("wawa",jsonObject.toString());
            cc.send(jsonObject.toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void right(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject("{uri:'/rooms/1/move/right',id:12,type:'post',data:{time:5000}}");
            System.out.println(jsonObject);
            Log.i("wawa","action");
            Log.i("wawa",jsonObject.toString());
            cc.send(jsonObject.toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    public void left(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject("{uri:'/rooms/1/move/left',id:12,type:'post',data:{time:5000}}");
            System.out.println(jsonObject);
            Log.i("wawa","action");
            Log.i("wawa",jsonObject.toString());
            cc.send(jsonObject.toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void front(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject("{uri:'/rooms/1/move/front',id:12,type:'post',data:{time:5000}}");
            System.out.println(jsonObject);
            Log.i("wawa","action");
            Log.i("wawa",jsonObject.toString());
            cc.send(jsonObject.toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    public void back(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject("{uri:'/rooms/1/move/back',id:12,type:'post',data:{time:5000}}");
            System.out.println(jsonObject);
            Log.i("wawa","action");
            Log.i("wawa",jsonObject.toString());
            cc.send(jsonObject.toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    public void action(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject("{uri:'/rooms/2/catch',id:12,type:'post',data:{}}");
            System.out.println(jsonObject);
            Log.i("wawa","action");
            Log.i("wawa",jsonObject.toString());
            cc.send(jsonObject.toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    public void stop(){
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject("{uri:'/rooms/2/stop',id:12,type:'post',data:{}}");
            System.out.println(jsonObject);
            Log.i("wawa","stop");
            Log.i("wawa",jsonObject.toString());
            cc.send(jsonObject.toString());
        } catch (JSONException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
    public void close(){
        cc.close();
    }

}
