package com.imooc.lib_audio.mediaplayer.events;

import com.mozhimen.biz_db.mos.AudioBean;

public class AudioLoadEvent {
  public AudioBean mAudioBean;

  public AudioLoadEvent(AudioBean audioBean) {
    this.mAudioBean = audioBean;
  }
}
