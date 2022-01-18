package romang.montejo.moya.Persistence;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import romang.montejo.moya.Model.AudioReminder;
import romang.montejo.moya.Model.PhotoReminder;
import romang.montejo.moya.Model.TextReminder;

@Dao
public interface DAO {
    // TODO: 07/11/2021 HACE DAO PLZ NACHO DE FUTURO
    @Insert Long insertTextReminder(TextReminder reminder);
    @Insert Long insertPhotoReminder(PhotoReminder reminder);
    @Insert Long insertAudioReminder(AudioReminder reminder);

    @Query("SELECT * FROM TextReminder") List<TextReminder> getAllTextReminder();
    @Query("SELECT * FROM PhotoReminder") List<PhotoReminder> getAllPhotoReminder();
    @Query("SELECT * FROM AudioReminder") List<AudioReminder> getAllAudioReminder();

    @Query("SELECT * FROM TextReminder WHERE datetime(time/1000, 'unixepoch') >= datetime('now', 'localtime', '-5 minutes') ") List<TextReminder> getTextReminder();
    @Query("SELECT * FROM PhotoReminder WHERE datetime(time/1000, 'unixepoch') >= datetime('now', 'localtime', '-5 minutes') ") List<PhotoReminder> getPhotoReminder();
    @Query("SELECT * FROM AudioReminder WHERE datetime(time/1000, 'unixepoch') >= datetime('now', 'localtime', '-5 minutes') ") List<AudioReminder> getAudioReminder();

    @Query("SELECT * FROM TextReminder WHERE title LIKE '%' || :search || '%' OR reminderText LIKE '%' || :search || '%'") List<TextReminder> findTextReminder(String search);
    @Query("SELECT * FROM PhotoReminder WHERE title LIKE '%' || :search || '%'") List<PhotoReminder> findPhotoReminder(String search);
    @Query("SELECT * FROM AudioReminder WHERE title LIKE '%' || :search || '%'") List<AudioReminder> findAudioReminder(String search);
}