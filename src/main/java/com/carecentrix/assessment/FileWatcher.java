package com.carecentrix.assessment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class FileWatcher {

    public static void WatchMyFolder(String path)
    {
        File dir = new File(path);
        Path myDir= dir.toPath();
        try
        {
            Boolean isFolder = (Boolean) Files.getAttribute(myDir,"basic:isDirectory", NOFOLLOW_LINKS);
            if (!isFolder)
            {
                throw new IllegalArgumentException("Path: " + myDir + " is not a folder");
            }
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }

        System.out.println("Watching path: " + myDir);

        try {
            WatchService watcher = myDir.getFileSystem().newWatchService();
            myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE,StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY);

            WatchKey watchKey = watcher.take();
            List<WatchEvent<?>> events = watchKey.pollEvents();

            for (WatchEvent event : events) {
                if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                    System.out.println("File Created: " + event.context().toString());
                }
                if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                    System.out.println("File Deleted: " + event.context().toString());
                }
                if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                    System.out.println("File Modified: " + event.context().toString());
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
    }
}
