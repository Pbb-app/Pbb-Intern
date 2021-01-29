package com.riseinsteps.packbagbuddy.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.riseinsteps.packbagbuddy.CancellationAndRefundPolicyActivity;
import com.riseinsteps.packbagbuddy.CopyRightPolicyActivity;
import com.riseinsteps.packbagbuddy.PrivacyPolicyActivity;
import com.riseinsteps.packbagbuddy.R;
import com.riseinsteps.packbagbuddy.TermsAndConditionActivity;

public class LegalPolicyFragment extends Fragment {
    private View view;
    private TextView termsAndCondition, CopyrightPolicy, PrivacyPolicy, CancellationAndRefund;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_legal_policy, container, false);


        termsAndCondition = view.findViewById(R.id.tv_terms_and_conditions);
        CopyrightPolicy = view.findViewById(R.id.tv_copyright_policy);
        PrivacyPolicy = view.findViewById(R.id.tv_privacy_policy);
        CancellationAndRefund = view.findViewById(R.id.tv_cancellation_and_refund);

        termsAndCondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), TermsAndConditionActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        CopyrightPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), CopyRightPolicyActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        PrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), PrivacyPolicyActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        CancellationAndRefund.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(view.getContext(), CancellationAndRefundPolicyActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        return view;

    }


}
