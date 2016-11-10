package time.kisoo.time.time2.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.app.App;
import time.kisoo.time.time2.dagger2.component.activity.DaggerWriteNodeActivityComponent;
import time.kisoo.time.time2.dagger2.module.activity.WriteNoteActivityModule;
import time.kisoo.time.time2.databinding.WriteNoteBinding;
import time.kisoo.time.time2.util.MyTextUtil;
import time.kisoo.time.time2.view.base.BaseActivity;
import time.kisoo.time.time2.viewmodel.activity.WriteNoteActivityVM;

/**
 * Created by KiSoo on 2016/11/2.
 */

public class WriteNoteActivity extends BaseActivity<WriteNoteBinding> implements TextWatcher {


    public static final String KEY_CONTENT = "KEY_CONTENT_WRITE_NOTE";

    @Inject
    WriteNoteActivityVM writeNoteActivityVM;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar();
        initContent();
        initView();
    }

    private void initToolbar() {
        initToolbar(binding.rlMain.tbMain, true);
    }

    @Override
    protected void bindView() {
        super.bindView();
        binding.setViewModel(writeNoteActivityVM);
    }

    @Override
    protected void initModelWithDagger2() {
        DaggerWriteNodeActivityComponent.builder()
                .appComponent(((App) getApplication()).component())
                .writeNoteActivityModule(new WriteNoteActivityModule(this, new SpannableStringBuilder("")))
                .build()
                .inject(this);
    }


    /**
     * use the content(String) from intent to build the editText
     */
    private void initContent() {
        String contents = getIntent().getStringExtra(KEY_CONTENT);
        if (TextUtils.isEmpty(contents))
            return;
        String[] s = contents.split("/n");
        int cursor = 0;
        if (MyTextUtil.isTitle(s[0])) {
            initContentWithSettings(0, s[0].length() - 1);
            cursor++;
        }
        initContent(s, cursor);

    }

    private void initContent(String[] contents, int cursor) {
        for (; cursor < contents.length; cursor++) {
            String s = contents[cursor];
            if (MyTextUtil.isImage(contents[cursor])) {

            }
        }
    }

    /**
     * add some listener
     */
    private void initView() {
        binding.etContent.addTextChangedListener(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_write_note;
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    /**
     * update the binding text
     *
     * @param start
     * @param end
     */
    private void initContentWithSettings(int start, int end) {
        writeNoteActivityVM.getContent().setSpan(new ForegroundColorSpan(writeNoteActivityVM.getColor()), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        writeNoteActivityVM.getContent().setSpan(new AbsoluteSizeSpan(writeNoteActivityVM.getTextSize(), true), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        writeNoteActivityVM.setContent((SpannableStringBuilder) s);
        initContentWithSettings(start, start + count);
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

}
