package org.example.engine.Camera;

public class CameraInfo {
    public static class CameraMovement {
        public boolean moveLeft, moveRight, moveUp, moveDown;
    }

    public int cameraMoveSpeed;
    public CameraMovement cameraMovement;

    public CameraInfo() {
        this.cameraMovement = new CameraMovement();
        this.cameraMoveSpeed = 10;
    }
}
